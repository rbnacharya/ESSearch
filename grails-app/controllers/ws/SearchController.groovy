package ws

import grails.converters.JSON

class SearchController {
    def query=""

    def index() { render init() as JSON}
    def init(){
        format()

        ""
    }
    def format(){
        params.remove("controller")
        params.remove("action")
        if (params.containsKey("query")){
            query=params.get("query")
        }
    }
}
