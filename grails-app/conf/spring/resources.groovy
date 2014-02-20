import ws.utils.query.LinkCountQueryBuilder
import ws.utils.query.QuerySearchQueryBuilder
import ws.utils.response.CountResponse
import ws.utils.response.QSearchResponse

// Place your Spring DSL code here
beans = {
    "search.requestBuilder"(QuerySearchQueryBuilder){bean->
        bean.scope="prototype"
    }
    "search.responseHandler"(QSearchResponse){bean->
        bean.scope="prototype"
    }
    "count.requestBuilder"(LinkCountQueryBuilder){bean->
        bean.scope="prototype"
    }
    "count.responseHandler"(CountResponse){bean->
        bean.scope="prototype"
    }
}
