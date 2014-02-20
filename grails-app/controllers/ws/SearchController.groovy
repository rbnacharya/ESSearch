package ws

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject
import ws.utils.request.RequestConstants
import ws.utils.request.SearchRequest

class SearchController {
    def query=""
    def searchService
    SearchRequest searchReq

    def index() {render init()?:new JSONObject() as JSON}
    def init(){
        format()
        if (params.containsKey(RequestConstants.QUERY)){
            query=params.get(RequestConstants.QUERY)
        }
        return searchService.search(searchReq)
    }
    def format(){
        setReportName()
        params.remove(RequestConstants.CONTROLLER_)
        params.remove(RequestConstants.ACTION_)
        setParams()
    }

    private void setReportName() {
        if (!params.containsKey(RequestConstants.REPORT_NAME)) {
            def reportName = actionName;
            if (actionName == "index") {
                reportName = "search"
            }
            params.put(RequestConstants.REPORT_NAME, reportName)
        }
    }

    private void setParams() {
        searchReq = new SearchRequest(parameters: getParams() ?: new HashMap<String, String>())
    }
}
