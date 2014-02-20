package ws.utils.esresources

import org.elasticsearch.client.Client
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.ImmutableSettings
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import ws.utils.configuration.ClusterSettings

/**
 * Created with IntelliJ IDEA.
 * User: racharya
 */
class ESConnector {
    static Client client;
    static ClusterSettings essettings=ClusterSettings.instance;
    static def connect(){
        Settings settings = ImmutableSettings.settingsBuilder()
                .put(ESConstants.CLUSTER_NAME_STR, essettings.clusterName).build();
        client = new TransportClient(settings);
            client.addTransportAddress(new InetSocketTransportAddress(essettings.hostName,essettings.tcpPort));
        println "connection to::"+essettings.hostName+":"+essettings.tcpPort+"----------------"
        return client;
    }
    static {
        connect()
    }
    static def getClient(){
        return client
    }

}
