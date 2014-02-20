package ws.utils.query

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.client.Client
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.search.sort.SortBuilders
import org.elasticsearch.search.sort.SortOrder
import ws.utils.mapping.CrawlerType
import ws.utils.mapping.SearchESType
import ws.utils.request.RequestUtil
import ws.utils.request.SearchRequest

/**
 * Created By: racharya
 * Date: 2/20/14 : 10:09 AM
 */
class QuerySearchQueryBuilder extends IQueryBuilder{
    @Override
    SearchRequestBuilder getQuery(Client cl,SearchRequest param) {
        QueryBuilder query= QueryUtil.getSearchQuery(RequestUtil.getQuery(param))
        SearchRequestBuilder srb=prepareSearch(cl,param)
                .addSort(SortBuilders.fieldSort(CrawlerType.ADDED_ON).order(SortOrder.DESC))
                .setSize(RequestUtil.getSize(param))
                .addFields(SearchESType.FIELDSTOFETCH)
        return srb
    }
}
