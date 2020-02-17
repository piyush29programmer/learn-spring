package com.example.learn.spring.learnspring;

import java.util.List;
import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.learn.spring.learnspring.connection.ElasticsearchClientConfiguration;
import com.example.learn.spring.learnspring.elasticsearch.ElasticsearchService;

@SpringBootApplication
public class LearnSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringApplication.class, args);
		
		/*
		 * ElasticsearchClientConfiguration clientConfiguration = new
		 * ElasticsearchClientConfiguration();
		 * 
		 * ElasticsearchService elasticsearchService = new ElasticsearchService();
		 * 
		 * List<Map<String,Object>> esData =
		 * elasticsearchService.getAllDocuments(clientConfiguration);
		 */
		
	}

}
