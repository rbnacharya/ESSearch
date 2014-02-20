package ws.utils.esresources

import org.elasticsearch.action.ActionListener
import org.elasticsearch.action.ActionRequestBuilder
import org.elasticsearch.action.ActionResponse
import ws.utils.response.IQueryResponse

import java.util.concurrent.atomic.AtomicBoolean

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
class Executor implements Runnable {
    ActionRequestBuilder req;
    ActionListener res;
    AtomicBoolean isComplete;

    Executor(ActionRequestBuilder req, ActionListener res) {
        this.req = req
        this.res = res
        isComplete=new AtomicBoolean(false)
    }

    @Override
    void run() {
        try{
            ActionResponse res=this.req.execute().actionGet()
            this.res.onResponse(res)
            isComplete.set(true)
        }
        catch (Exception e){
            isComplete.set(true)
        }
    }
    public String getResponse(){
        return ((IQueryResponse)res).getResponse()
    }
}
