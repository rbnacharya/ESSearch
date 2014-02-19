package crawler

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.index.query.QueryBuilder
import ws.utils.SettingsES
import ws.utils.es.ESConnector
import ws.utils.query.LinkCountQueryBuilder
import ws.utils.query.QueryUtil
import ws.utils.response.CountResponse
import ws.utils.response.QSearchResponse
import ws.utils.response.IQueryResponse

class SearchService {
    String type;
    String queryString;
    Integer pageSize=10;

    def search(String query) {
        type=SettingsES.instance.typeSearch
        queryString=query
        return getSearchQuery()
    }
    def getSearchQuery(){
        SearchRequestBuilder req=
            ESConnector.getClient().prepareSearch("cl1")
            .setTypes(type)
        QueryBuilder searchQuery=QueryUtil.getSearchQuery(queryString)
        req.setQuery(searchQuery)
        req.addFields("link","title","body")
        SearchResponse sr=req.execute().actionGet()
        println req
        println sr
        QSearchResponse res=new QSearchResponse()
        res.onResponse(sr)
        return res.getResponse();
    }
    def count(Map<String,Object> param){
        SearchRequestBuilder searchQuery=new LinkCountQueryBuilder().getQuery(ESConnector.client,param)
        SearchResponse sr=searchQuery.execute().actionGet()
        IQueryResponse res=new CountResponse()
        res.onResponse(sr)
        println searchQuery
        return res.getResponse();
    }
    def getClient(){
        return "cl1"
    }

}
