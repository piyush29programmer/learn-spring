package com.example.learn.spring.learnspring.elasticsearch;

import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.action.search.SearchType;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.unit.TimeValue;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.sort.FieldSortBuilder;
import org.elasticsearch.search.sort.SortOrder;

import com.example.learn.spring.learnspring.connection.ElasticsearchClientConfiguration;

public class ElasticsearchService {
	List<Map<String, Object>> esData = new ArrayList<Map<String, Object>>();

	public List<Map<String, Object>> getAllDocuments(ElasticsearchClientConfiguration clientConfiguration) {

		try {

			TransportClient client = clientConfiguration.transportClient();

			QueryBuilder builders = QueryBuilders.matchAllQuery();
			/*
			 * @SuppressWarnings("deprecation") SearchResponse scrollResp =
			 * client.prepareSearch("knowledgebasemapping")
			 * .setSearchType(SearchType.QUERY_THEN_FETCH).setQuery(builders)
			 * .addSort(FieldSortBuilder.DOC_FIELD_NAME, SortOrder.ASC) .setScroll(new
			 * TimeValue(60000)) .setSize(100) .execute() .actionGet();
			 * 
			 * do {
			 * 
			 * for (SearchHit hit : scrollResp.getHits().getHits()) {
			 * esData.add(hit.getSourceAsMap()); }
			 * 
			 * } while (scrollResp.getHits().getHits().length != 0);
			 */

			SearchResponse response = client.prepareSearch("spring_learning_mapping")
					.setSearchType(SearchType.QUERY_AND_FETCH).setQuery(builders).setFrom(0).setSize(100)
					.setExplain(true).execute().actionGet();

			SearchHit[] results = response.getHits().getHits();
			System.out.println("Current results: " + results.length);
			for (SearchHit hit : results) {
				System.out.println("------------------------------");
				Map<String, Object> result = hit.getSourceAsMap();
				System.out.println(result);
			}

		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return esData;

	}

	public List<Map<String, Object>> getDocumentById() {
		return null;
	}

	public List<Map<String, Object>> getUniqueCategory() {
		return null;
	}
}
