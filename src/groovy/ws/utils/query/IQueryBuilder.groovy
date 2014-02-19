package ws.utils.query

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.client.Client
import org.elasticsearch.index.query.QueryBuilder

/**
 * Created By: racharya
 * Date: 2/19/14 : 1:51 PM
 */
 interface IQueryBuilder {
    public SearchRequestBuilder getQuery(Client cl,Map<String,Object> param);
}
