package ws.utils.response

import org.codehaus.groovy.grails.web.json.JSONArray
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.search.SearchHit
import ws.utils.mapping.AbstractType

/**
 * Created By: racharya
 * Date: 2/20/14 : 11:04 AM
 */
public abstract class DefaultFieldResponse extends IQueryResponse<SearchResponse>{
    @Override
    void processResponse(SearchResponse response) {
        JSONArray jsonArr=new JSONArray()
        for(SearchHit hit:response.getHits().getHits()){
            jsonArr.put(getDefaultFields(hit.fields(),getESType()))
        }
        outputJSON.put(ResponseConstants.HITS,jsonArr)
    }
    abstract AbstractType getESType();
}
