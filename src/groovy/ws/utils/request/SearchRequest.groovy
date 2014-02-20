package ws.utils.request

/**
 * Zadcor created this package on
 * 2/19/14, copyright is reserved with zadcor
 */
public class SearchRequest {
    Map<String,String> parameters=Collections.emptyMap();
    public String get(String key){
        return parameters.get(key);
    }
    public String getRemove(String key){
        String val=parameters.get(key);
        parameters.remove(key);
        return val;
    }
    public void put(String key,String val){
        parameters.put(key,val);
    }
    public Boolean contains(String key){
        return parameters.containsKey(key);
    }
    public Set<String> keys(){
        return parameters.keySet();
    }
}
