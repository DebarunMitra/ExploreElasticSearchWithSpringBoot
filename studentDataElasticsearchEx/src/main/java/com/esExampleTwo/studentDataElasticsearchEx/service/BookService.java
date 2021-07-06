package com.esExampleTwo.studentDataElasticsearchEx.service;

import com.esExampleTwo.studentDataElasticsearchEx.helper.Indices;
import com.esExampleTwo.studentDataElasticsearchEx.model.Book;
import com.esExampleTwo.studentDataElasticsearchEx.search.SearchRequestDTO;
import com.esExampleTwo.studentDataElasticsearchEx.search.util.SearchUtil;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.elasticsearch.action.get.GetRequest;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.RequestOptions;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.elasticsearch.rest.RestStatus;
import org.elasticsearch.search.SearchHit;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class BookService {

    private static final ObjectMapper MAPPER = new ObjectMapper();
    private static final Logger LOG = LoggerFactory.getLogger(Book.class);

    private final RestHighLevelClient client;

    @Autowired
    public BookService(RestHighLevelClient client) {
        this.client = client;
    }

    public List<Book> search(final SearchRequestDTO dto) {
        final SearchRequest request = SearchUtil.buildSearchRequest(
                Indices.BOOK_INDEX,
                dto
        );

        if (request == null) {
            LOG.error("Failed to build search request");
            return Collections.emptyList();
        }

        try {
            final SearchResponse response = client.search(request, RequestOptions.DEFAULT);

            final SearchHit[] searchHits = response.getHits().getHits();
            final List<Book> book = new ArrayList<>(searchHits.length);
            for (SearchHit hit : searchHits) {
                book.add(
                        MAPPER.readValue(hit.getSourceAsString(), Book.class)
                );
            }

            return book;
        } catch (Exception e) {
            LOG.error(e.getMessage(), e);
            return Collections.emptyList();
        }
    }


    public Boolean index(final Book book) {
        try {
            final String bookAsString = MAPPER.writeValueAsString(book);

            final IndexRequest request = new IndexRequest(Indices.BOOK_INDEX);
            request.id(book.getId());
            request.source(bookAsString, XContentType.JSON);

            final IndexResponse response = client.index(request, RequestOptions.DEFAULT);

            return response != null && response.status().equals(RestStatus.OK);
        } catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return false;
        }
    }


    public Book getById(final String bookId) {
        try {
            final GetResponse documentFields = client.get(
                    new GetRequest(Indices.BOOK_INDEX, bookId),
                    RequestOptions.DEFAULT
            );
            if (documentFields == null || documentFields.isSourceEmpty()) {
                return null;
            }

            return MAPPER.readValue(documentFields.getSourceAsString(), Book.class);
        } catch (final Exception e) {
            LOG.error(e.getMessage(), e);
            return null;
        }
    }

}
