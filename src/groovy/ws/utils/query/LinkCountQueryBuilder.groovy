package ws.utils.query

import org.elasticsearch.action.search.SearchRequestBuilder
import org.elasticsearch.client.Client
import org.elasticsearch.index.query.FilterBuilder
import org.elasticsearch.index.query.FilterBuilders
import org.elasticsearch.index.query.QueryBuilder
import org.elasticsearch.index.query.QueryBuilders
import org.elasticsearch.search.sort.SortBuilders
import org.elasticsearch.search.sort.SortOrder
import ws.utils.mapping.CrawlerType
import ws.utils.request.SearchRequest

/**
 * Created By: racharya
 * Date: 2/19/14 : 1:51 PM
 */
public class LinkCountQueryBuilder extends IQueryBuilder {
    String ARRAY_START ="["
    String ARRAY_END="]"
    String ARRAY_ITEM_SEPR=","
    @Override
    SearchRequestBuilder getQuery(Client cl,SearchRequest param) {
        SearchRequestBuilder srb=prepareSearch(cl,param)
        FilterBuilder filter= FilterBuilders.termsFilter(CrawlerType.SEARCHON,getLinks(param))
        QueryBuilder query= QueryBuilders.filteredQuery(QueryBuilders.matchAllQuery(),filter)
        srb.setQuery(query)
        .addSort(SortBuilders.fieldSort(CrawlerType.ADDED_ON).order(SortOrder.DESC)).setSize(1)
        .addFields(CrawlerType.FIELDSTOFETCH)
        return srb
    }
    public Set<String> getLinks(SearchRequest param){
        String link=param.get(CrawlerType.LINK)
        if (link.startsWith(ARRAY_START) && (link.endsWith(ARRAY_END))){
            link=link.substring(1,link.length()-1)
            Set<String> toSend=link.tokenize(ARRAY_ITEM_SEPR)
            return toSend
        }
        else
            return [link]
    }
}
