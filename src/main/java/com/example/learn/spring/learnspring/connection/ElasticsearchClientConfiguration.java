package com.example.learn.spring.learnspring.connection;

import java.net.InetAddress;
import java.net.UnknownHostException;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ElasticsearchClientConfiguration {
	@SuppressWarnings("resource")
	TransportAddress address1;
	TransportAddress address2;
	TransportClient client;
	Settings settings;
    
	public TransportClient transportClient() throws UnknownHostException {
		
		address1 = new TransportAddress(InetAddress.getByName("localhost"), 9200);
		address2= new TransportAddress(InetAddress.getByName("localhost"), 9300);
		 settings = Settings
				 .builder()
				 .put("cluster.name", "elasticsearch")
				 .put("client.transport.sniff", true)
				 .build();
		 client = new PreBuiltTransportClient(settings)
		 		  .addTransportAddress(address1)
		 		  .addTransportAddress(address2);
		 
		 return client;
	}
}
