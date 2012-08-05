package com.ds.cvbank.congiguration;

import io.searchbox.client.ElasticSearchClient;
import io.searchbox.client.ElasticSearchClientFactory;
import io.searchbox.client.config.ClientConfig;
import io.searchbox.client.config.ClientConstants;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashSet;

/**
 * @author Dogukan Sonmez
 */

@Configuration
public class SpringConfiguration {

    public @Bean
    ClientConfig clientConfig(){
        ClientConfig clientConfig = new ClientConfig();
        LinkedHashSet servers = new LinkedHashSet();
        servers.add("http://localhost:9200");
        clientConfig.getServerProperties().put(ClientConstants.SERVER_LIST,servers);
        clientConfig.getClientFeatures().put(ClientConstants.IS_MULTI_THREADED,true);
        clientConfig.getClientFeatures().put(ClientConstants.DEFAULT_INDEX,"cvbank");
        clientConfig.getClientFeatures().put(ClientConstants.DEFAULT_TYPE,"candidate");
        return clientConfig;
    }

    public @Bean
    ElasticSearchClient elasticSearchClient(){
        ElasticSearchClientFactory factory = new ElasticSearchClientFactory();
        factory.setClientConfig(clientConfig());
        return factory.getObject();
    }
}
