package ws.utils.es

import org.elasticsearch.client.Client
import org.elasticsearch.client.transport.TransportClient
import org.elasticsearch.common.settings.ImmutableSettings
import org.elasticsearch.common.settings.Settings
import org.elasticsearch.common.transport.InetSocketTransportAddress
import ws.utils.SettingsES

/**
 * Created with IntelliJ IDEA.
 * User: racharya
 */
class ESConnector {
    static Client client;
    static SettingsES essettings=SettingsES.instance;
    static def connect(){
        Settings settings = ImmutableSettings.settingsBuilder()
                .put("cluster.name", essettings.clusterName).build();
        TransportClient client = new TransportClient(settings);
            client.addTransportAddress(new InetSocketTransportAddress(essettings.hostName,essettings.tcpPort));
        return client;
    }
    static {
        connect()
    }
    static def getClient(){
        return client
    }

}
