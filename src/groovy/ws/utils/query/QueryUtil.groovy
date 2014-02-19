package ws.utils.query

import org.elasticsearch.index.query.MatchQueryBuilder
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders

/**
 * Created By: racharya
 * Date: 2/19/14 : 9:50 AM
 */
public class QueryUtil {
    static def getSearchQuery(String queryString){
        float boost1=0.50
        float boost2=0.01
        QueryBuilder searchQuery=
            QueryBuilders.multiMatchQuery(queryString)
                .operator(MatchQueryBuilder.Operator.AND)
                .field("title",boost1)
                .field("body",boost2)
        return searchQuery;
    }
}
