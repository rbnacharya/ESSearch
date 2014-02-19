package ws.utils.response

import org.codehaus.groovy.grails.web.json.JSONArray
import org.codehaus.groovy.grails.web.json.JSONObject
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.common.xcontent.XContentBuilder
import org.elasticsearch.common.xcontent.XContentFactory
import org.elasticsearch.search.SearchHit
import org.elasticsearch.search.SearchHitField

/**
 * Created By: racharya
 * Date: 2/19/14 : 10:32 AM
 */
public class QSearchResponse extends IQueryResponse<SearchResponse> {
    @Override
    void onResponse(SearchResponse response) {
        outputJSON=new JSONObject()
        JSONArray jsonArr=new JSONArray()
        for(SearchHit hit:response.getHits().getHits()){
            jsonArr.put(processResponse(hit.fields()))
        }
        outputJSON.put("search_responses",jsonArr)
    }

    static def processResponse(Map<String, SearchHitField> objectMap) {
        JSONObject jsonObject1=new JSONObject()
        jsonObject1.put("title",objectMap.get("title").value())
        jsonObject1.put("link",objectMap.get("link").value())
        jsonObject1.put("content",objectMap.get("body").value().toString().substring(0,300))
        return jsonObject1
    }
}
