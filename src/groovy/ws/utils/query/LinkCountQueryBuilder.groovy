package ws.utils.query

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.client.Client
import org.elasticsearch.index.query.FilterBuilder
import org.elasticsearch.index.query.FilterBuilders
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.sort.SortBuilders
import org.elasticsearch.search.sort.SortOrder

/**
 * Created By: racharya
 * Date: 2/19/14 : 1:51 PM
 */
public class LinkCountQueryBuilder implements IQueryBuilder {
    @Override
    SearchRequestBuilder getQuery(Client cl,Map<String, Object> param) {
        SearchRequestBuilder srb=cl.prepareSearch("cl1")
        String link=param.get("link")
        FilterBuilder filter= FilterBuilders.termsFilter("link.raw",getLinks(link))
        QueryBuilder query= QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(),filter)
        srb.setQuery(query)
        .addSort(SortBuilders.fieldSort("addedOn").order(SortOrder.DESC)).setSize(1)
        .addFields("link","addedOn")
        return srb
    }
    public Set<String> getLinks(String link){
        if (link.startsWith("[") && (link.endsWith("]"))){
            link=link.substring(1,link.length()-1)
            Set<String> toSend=link.tokenize(",")
            return toSend
        }
        else
            return [link]
    }
}
