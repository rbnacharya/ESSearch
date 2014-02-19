package ws.utils

import org.yaml.snakeyaml.Yaml

/**
 * Created By: racharya
 * Date: 2/18/14 : 5:22 PM
 */
class Settings {
    Map<String,String> settingMap=Collections.emptyMap();
    static Settings settings;
    public static Settings getInstance(def settingFile) {
        if (settings==null)
            buildSettings(settingFile)
        return settings
    }
    Settings(Map<String, String> settingMap) {
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
    public static void buildSettings(String settingFile){
        Yaml yaml=new Yaml()
        InputStream is=new FileInputStream(settingFile)
        Map smap=(Map)yaml.load(is)
        settings=new Settings(smap)
    }
}
