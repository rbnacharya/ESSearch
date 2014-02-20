package ws.utils.configuration

import org.yaml.snakeyaml.Yaml

/**
 * Created By: racharya
 * Date: 2/18/14 : 5:22 PM
 */
class ESSettings {
    Map<String,String> settingMap=Collections.emptyMap();

    ESSettings() {
    }

    ESSettings(Map<String, String> settingMap) {
        setSettingMap(settingMap)
    }

    void setSettingMap(Map<String, String> settingMap) {
        this.settingMap = settingMap
    }

    public String get(String key){
        return settingMap.get(key)
    }
    public Boolean contains(String key){
        return settingMap.containsKey(key)
    }
    public Set<String> keys(){
        return settingMap.keySet()
    }
    public void parse(String settingFile){
        Yaml yaml=new Yaml()
        InputStream is=new FileInputStream(settingFile)
        Map smap=(Map)yaml.load(is)
        setSettingMap(smap)
    }
}
