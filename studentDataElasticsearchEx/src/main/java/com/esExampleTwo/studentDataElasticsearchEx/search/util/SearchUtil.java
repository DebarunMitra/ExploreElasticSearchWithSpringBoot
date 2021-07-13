package com.esExampleTwo.studentDataElasticsearchEx.search.util;

import com.esExampleTwo.studentDataElasticsearchEx.search.SearchRequestDTO;
import org.elasticsearch.action.search.SearchRequest;
import org.elasticsearch.common.unit.Fuzziness;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.builder.SearchSourceBuilder;
import org.springframework.util.CollectionUtils;

import java.util.List;

public class SearchUtil {

    private SearchUtil() {}

    public static SearchRequest buildSearchRequest(final String indexName, final SearchRequestDTO dto) {

        try {
            final SearchSourceBuilder builder = new SearchSourceBuilder()
                    .postFilter(getQueryBuilder(dto));

            final SearchRequest request = new SearchRequest(indexName);
            request.source(builder);

            return request;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static QueryBuilder getQueryBuilder(final SearchRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        final List<String> fields = dto.getFields();
        if (CollectionUtils.isEmpty(fields)) {
            return null;
        }

        if (fields.size() > 1) {
            final MultiMatchQueryBuilder queryBuilder = QueryBuilders.multiMatchQuery(dto.getSearchTerm())
                    .type(MultiMatchQueryBuilder.Type.CROSS_FIELDS)
                    .operator(Operator.AND);


            fields.forEach(queryBuilder::field);

            return queryBuilder;
        }

        return fields.stream()
                .findFirst()
                .map(field ->
                        QueryBuilders.matchQuery(field, dto.getSearchTerm())
                                .operator(Operator.AND))
                .orElse(null);
    }

    public static SearchRequest buildSearchLocationRequest(final String indexName, final SearchRequestDTO dto) {

        try {
            final SearchSourceBuilder builder = new SearchSourceBuilder()
                    .postFilter(getLocationQueryBuilder(dto)).from(dto.getSearchLocationFrom()).size(dto.getSearchLocationSize());

            final SearchRequest request = new SearchRequest(indexName);
            request.source(builder);

            return request;
        } catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private static QueryBuilder getLocationQueryBuilder(final SearchRequestDTO dto) {
        if (dto == null) {
            return null;
        }

        try{
            final String fieldLocation = dto.getFieldLocation();
            if (fieldLocation.isEmpty()) {
                return null;
            }

            final QueryBuilder queryBuilder = QueryBuilders.matchQuery(fieldLocation, dto.getSearchLocation())
                    .operator(Operator.AND).fuzziness(Fuzziness.TWO);

//            final QueryBuilder queryBuilder = QueryBuilders.matchQuery(QueryBuilders.fuzzyQuery(fieldLocation, dto.getSearchLocation()));
//                    .operator(Operator.AND);

            if(queryBuilder == null){
                return null;
            }

            return queryBuilder;

        }catch (final Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
