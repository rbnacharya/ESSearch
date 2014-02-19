package ws.utils

/**
 * Created By: racharya
 * Date: 2/18/14 : 5:42 PM
 */
public  class SettingsES{
    static String settingsFile="config/settings.yml"
    String clusterName;
    String hostName;
    String httpPort;
    String tcpPort;
    String defaultIndex;
    String typeSearch;
    String typeCrawler;
    Settings settings1;
    static SettingsES sett;

    public static SettingsES getInstance() {
        if (sett==null)
            sett=new SettingsES()
        return sett;
    }
    SettingsES() {
        this.settings1 = Settings.getInstance(settingsFile)
        init()
    }
    def init(){
        clusterName=settings1.get(SettingsConstants.CLUSTER_NAME)
        hostName=settings1.get(SettingsConstants.HOST_NAME)
        httpPort=settings1.get(SettingsConstants.HTTP_PORT)
        tcpPort=settings1.get(SettingsConstants.TCP_PORT)
        defaultIndex=settings1.get(SettingsConstants.DEFAULT_INDEX)
        typeSearch=settings1.get(SettingsConstants.TYPE_SEARCH)
        typeCrawler=settings1.get(SettingsConstants.TYPE_CRAWLER)
    }
    String getClusterName() {
        return clusterName
    }

    String getHostName() {
        return hostName
    }

    String getHttpPort() {
        return httpPort
    }

    Integer getTcpPort() {
        return Integer.parseInt(tcpPort)
    }

    String getDefaultIndex() {
        return defaultIndex
    }

    String getTypeSearch() {
        return typeSearch
    }

    String getTypeCrawler() {
        return typeCrawler
    }
}