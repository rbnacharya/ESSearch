package ws.utils.query

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.client.Client
import ws.utils.request.SearchRequest
import ws.utils.support.SearchUtil

/**
 * Created By: racharya
 * Date: 2/19/14 : 1:51 PM
 */
public abstract class IQueryBuilder extends SearchUtil{
    public abstract SearchRequestBuilder getQuery(Client cl,SearchRequest param);
}
