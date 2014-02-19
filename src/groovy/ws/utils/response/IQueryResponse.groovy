package ws.utils.response

import org.codehaus.groovy.grails.web.json.JSONObject
import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.ActionResponse

/**
 * Created By: racharya
 * Date: 2/19/14 : 2:11 PM
 */
 public abstract class IQueryResponse<E> implements ActionListener<E>{
     public JSONObject outputJSON;
     public String getResponse(){
         return outputJSON.toString()
     }

     @Override
     void onFailure(Throwable throwable) {
         //To change body of implemented methods use File | Settings | File Templates.
     }
 }
