package ws.utils.support

import ws.utils.configuration.ClusterSettings
import ws.utils.request.RequestConstants
import ws.utils.request.SearchRequest

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
class ClientUtil {
    static def getDefaultIndex(){
        return ClusterSettings.instance.defaultIndex
    }
    static def getIndex(SearchRequest req){
        if (req.contains(RequestConstants.CLIENT_ID)){
            return req.get(RequestConstants.CLIENT_ID)
        }
        return getDefaultIndex()
    }

}
