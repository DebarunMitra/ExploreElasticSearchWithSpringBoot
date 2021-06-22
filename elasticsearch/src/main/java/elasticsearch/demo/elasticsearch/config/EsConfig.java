package elasticsearch.demo.elasticsearch.config;


//import org.elasticsearch.client.Client;
//import org.elasticsearch.client.transport.TransportClient;
//import org.elasticsearch.common.settings.Settings;
//import org.elasticsearch.common.transport.TransportAddress;
//import org.elasticsearch.transport.client.PreBuiltTransportClient;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.elasticsearch.core.ElasticsearchOperations;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
//
//import java.net.InetAddress;
//import java.net.UnknownHostException;
//
//
//@Configuration
//@EnableElasticsearchRepositories(basePackages = "spring.data.elasticsearch.repositories")
//@ComponentScan(basePackages = { "spring.data.elasticsearch.services" })
public class EsConfig {

//    @Bean
//    public Client getClient() throws UnknownHostException {
//        Settings setting = Settings
//                .builder()
//                .put("client.transport.sniff", true)
//                .put("path.home", "/usr/share/elasticsearch") //elasticsearch home path
//                .put("first-es-setup", "elasticsearch")
//                .build();
//        //please note that client port here is 9300 not 9200!
//        TransportClient client = new PreBuiltTransportClient(setting)
//                .addTransportAddress(new TransportAddress(InetAddress.getByName("127.0.0.1"), 9300));
//        return client;
//    }

//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() throws UnknownHostException {
//        return new ElasticsearchTemplate(getClient());
//    }

//    @Bean
//    public RestHighLevelClient client() {
//        ClientConfiguration clientConfiguration
//                = ClientConfiguration.builder()
//                .connectedTo("localhost:9200")
//                .build();
//
//        return RestClients.create(clientConfiguration).rest();
//    }
//
//    @Bean
//    public ElasticsearchOperations elasticsearchTemplate() {
//        return new ElasticsearchRestTemplate(client());
//    }
}
