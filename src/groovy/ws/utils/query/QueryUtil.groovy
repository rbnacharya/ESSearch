package ws.utils.query

import org.elasticsearch.index.query.MatchQueryBuilder
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import ws.utils.mapping.SearchESType

/**
 * Created By: racharya
 * Date: 2/19/14 : 9:50 AM
 */
 class QueryUtil {
    static def getSearchQuery(String queryString){
        float boost1=3
        float boost2=1
        QueryBuilder searchQuery=
            QueryBuilders.multiMatchQuery(queryString)
                .operator(MatchQueryBuilder.Operator.AND)
                .field(SearchESType.TITLE,boost1)
                .field(SearchESType.BODY,boost2)
        return searchQuery;
    }

}
