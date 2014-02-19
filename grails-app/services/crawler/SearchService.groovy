package crawler

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.index.query.QueryBuilder
import ws.utils.SettingsES
import ws.utils.es.ESConnector

class SearchService {
    String type;

    def search(String query) {
        type=SettingsES.instance.typeSearch
    }
    def getSearchQuery(){
        SearchRequestBuilder req=
            ESConnector.getClient().prepareSearch()
            .setTypes(type)
        QueryBuilder searchQuery=

    }
}
