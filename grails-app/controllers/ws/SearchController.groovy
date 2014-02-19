package ws

import grails.converters.JSON
import org.codehaus.groovy.grails.web.json.JSONObject

class SearchController {
    def query=""
    def searchService
    def index() {render init()?:new JSONObject() as JSON}
    def init(){
        format()
        return searchService.search(query)
    }
    def format(){
        params.remove("controller")
        params.remove("action")
        if (params.containsKey("query")){
            query=params.get("query")
        }
    }
    def count(){
       format()
       if (params.containsKey("link"))
       {
           render searchService.count(getParams())?:new JSONObject() as JSON
       }else{

           render "error"
       }

    }
}
