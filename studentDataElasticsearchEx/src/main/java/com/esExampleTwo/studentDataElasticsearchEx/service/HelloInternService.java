package com.esExampleTwo.studentDataElasticsearchEx.service;


import com.esExampleTwo.studentDataElasticsearchEx.helper.Indices;
import com.esExampleTwo.studentDataElasticsearchEx.model.Book;
import com.esExampleTwo.studentDataElasticsearchEx.model.HelloInterns;
import com.esExampleTwo.studentDataElasticsearchEx.search.SearchRequestDTO;
import com.esExampleTwo.studentDataElasticsearchEx.search.util.SearchUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class HelloInternService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(HelloInterns.class);

    private final RestHighLevelClient client;

    @Autowired
    public HelloInternService(RestHighLevelClient client) {
        this.client = client;
    }


//    public HelloInterns getByTitle(final String internshipTitle) {
//        try {
//            final GetResponse documentFields = client.get(
//                    new GetRequest(Indices.INTERNSHIP_INDEX, internshipTitle),
//                    RequestOptions.DEFAULT
//            );
//            if (documentFields == null || documentFields.isSourceEmpty()) {
//                return null;
//            }
//
//            return MAPPER.readValue(documentFields.getSourceAsString(), HelloInterns.class);
//        } catch (final Exception e) {
//            LOG.error(e.getMessage(), e);
//            return null;
//        }
//    }

    public List<HelloInterns> getByLocation(final SearchRequestDTO dto) {
        final SearchRequest request = SearchUtil.buildSearchLocationRequest(
                Indices.INTERNSHIP_INDEX,
                dto
        );

        if (request == null) {
            LOG.error("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);

            final SearchHit[] searchHits = response.getHits().getHits();
            final List<HelloInterns> helloInterns = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                helloInterns.add(
                        MAPPER.readValue(hit.getSourceAsString(), HelloInterns.class)
                );
            }

            return helloInterns;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }

    public List<HelloInterns> search(final SearchRequestDTO dto) {
        final SearchRequest request = SearchUtil.buildSearchRequest(
                Indices.INTERNSHIP_INDEX,
                dto
        );

        if (request == null) {
            LOG.error("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);

            final SearchHit[] searchHits = response.getHits().getHits();
            final List<HelloInterns> helloInterns = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                helloInterns.add(
                        MAPPER.readValue(hit.getSourceAsString(), HelloInterns.class)
                );
            }

            return helloInterns;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }
}
