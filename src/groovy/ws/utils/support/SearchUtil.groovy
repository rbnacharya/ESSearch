package ws.utils.support

import org.elasticsearch.action.ActionRequestBuilder
import org.elasticsearch.client.Client
import ws.utils.query.IQueryBuilder
import ws.utils.request.SearchRequest
import ws.utils.response.IQueryResponse

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
class SearchUtil {
    public static ActionRequestBuilder prepareSearch(Client cl,SearchRequest req){
        String client=ClientUtil.getIndex(req)
        return cl.prepareSearch(client)
    }

    public static IQueryBuilder getBuilder(String report){
        if (SpringBeanUtils.isBeanExist(report+ApplicationConstants.BEAN_REQUEST_BUILDER)){
         return SpringBeanUtils.getBean(report+ApplicationConstants.BEAN_REQUEST_BUILDER)
        }
        return null
    }
    public static IQueryResponse getListener(String report){
        if (SpringBeanUtils.isBeanExist(report+ApplicationConstants.BEAN_RESPONSE_HANDLER)){
            return SpringBeanUtils.getBean(report+ApplicationConstants.BEAN_RESPONSE_HANDLER)
        }
        return null
    }
}
