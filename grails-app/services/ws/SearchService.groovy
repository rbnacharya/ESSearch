package ws

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.ActionRequestBuilder
import ws.utils.configuration.ClusterSettings
import ws.utils.esresources.ESConnector
import ws.utils.esresources.Executor
import ws.utils.query.IQueryBuilder
import ws.utils.request.RequestConstants
import ws.utils.request.SearchRequest
import ws.utils.response.IQueryResponse
import ws.utils.support.SearchUtil

class SearchService {
    String type;
    Integer pageSize=10;
    SearchRequest request;

    def search(SearchRequest request) {
        type=ClusterSettings.instance.typeSearch
        this.request=request
        return getResponse()
    }
    def getResponse(){
        IQueryBuilder iqb= getBuilder()
        ActionListener listener= getListener()
        if (isNulls(iqb, listener)){
            return ""
        }
        return execute(iqb, listener)
    }

    private String execute(IQueryBuilder iqb, IQueryResponse listener) {
        ActionRequestBuilder builder = iqb.getQuery(getClient(), request)
        def executor = new Executor(builder, listener)
        executor.run()
        while (!executor.isComplete.get()) {
            Thread.sleep(100)
        }
        return executor.getResponse()
    }

    private boolean isNulls(IQueryBuilder iqb, IQueryResponse listener) {
        (iqb == null) && (listener == null)
    }

    private IQueryResponse getListener() {
        SearchUtil.getListener(getReportName())
    }

    private IQueryBuilder getBuilder() {
        SearchUtil.getBuilder(getReportName())
    }

    private String getReportName() {
        request.get(RequestConstants.REPORT_NAME)
    }

    def getClient(){
        return ESConnector.getClient()
    }
}
