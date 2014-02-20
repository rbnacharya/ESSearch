package ws.utils.response

import org.codehaus.groovy.grails.web.json.JSONObject
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.ActionResponse
import org.elasticsearch.action.search.SearchResponse
import org.elasticsearch.search.SearchHitField
import ws.utils.mapping.AbstractType

/**
 * Created By: racharya
 * Date: 2/19/14 : 2:11 PM
 */
 public abstract class IQueryResponse<E extends ActionResponse> implements ActionListener<E>{
     public JSONObject outputJSON;
     public String getResponse(){
         return outputJSON.toString()
     }

     @Override
     void onResponse(E response) {
         if (response instanceof SearchResponse){
             init(response)
         }
         else{
             outputJSON=new JSONObject()
         }
         processResponse(response)
     }
     abstract void processResponse(E res);
     @Override
     void onFailure(Throwable throwable) {
         //To change body of implemented methods use File | ESSettings | File Templates.
     }
     static JSONObject getDefaultFields(Map<String,SearchHitField> hit,AbstractType type){
         JSONObject jsonObject1=new JSONObject()
         for(String field:type.getFIELDSTOFETCH()){
             jsonObject1.put(field,hit.get(field).value())
         }
         return jsonObject1

     }
     def init(SearchResponse response){
         outputJSON=new JSONObject()
         outputJSON.put(ResponseConstants.TIME_TAKEN,response.getTook().millis())
         outputJSON.put(ResponseConstants.TOTAL_HITS,response.getHits().totalHits())
     }

 }
