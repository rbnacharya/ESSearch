package ws.utils.configuration

/**
 * Created By: racharya
 * Date: 2/18/14 : 5:42 PM
 */
public  class ClusterSettings extends ESSettings{
    static String settingsFile=SettingsConstants.CONFIG_FILE
    String clusterName;
    String hostName;
    String httpPort;
    String tcpPort;
    String defaultIndex;
    String typeSearch;
    String typeCrawler;
    static ClusterSettings sett;

    public static ClusterSettings getInstance() {
        if (sett==null)
            sett=new ClusterSettings()
        return sett;
    }

    ClusterSettings() {
        parse(settingsFile)
        init()
    }
    def init(){
        clusterName=get(SettingsConstants.CLUSTER_NAME)
        hostName=get(SettingsConstants.HOST_NAME)
        httpPort=get(SettingsConstants.HTTP_PORT)
        tcpPort=get(SettingsConstants.TCP_PORT)
        defaultIndex=get(SettingsConstants.DEFAULT_INDEX)
        typeSearch=get(SettingsConstants.TYPE_SEARCH)
        typeCrawler=get(SettingsConstants.TYPE_CRAWLER)
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