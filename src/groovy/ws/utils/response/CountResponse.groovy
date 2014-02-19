package ws.utils.response

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.search.SearchHit
import org.elasticsearch.search.SearchHitField

/**
 * Created By: racharya
 * Date: 2/19/14 : 2:12 PM
 */
public class CountResponse extends IQueryResponse<SearchResponse>{
    @Override
    void onResponse(SearchResponse response) {
        println response
        outputJSON=new JSONObject()
        JSONArray jsonArr=new JSONArray()
        for(SearchHit hit:response.getHits().getHits()){
            jsonArr.put(processResponse(hit.fields()))
        }
        outputJSON.put("reports",jsonArr)

    }
    def processResponse(Map<String,SearchHitField> hit){
        JSONObject jsonObject1=new JSONObject()
        jsonObject1.put("link",hit.get("link").value())
        jsonObject1.put("addedOn",hit.get("addedOn").value())
        return jsonObject1
    }
}
