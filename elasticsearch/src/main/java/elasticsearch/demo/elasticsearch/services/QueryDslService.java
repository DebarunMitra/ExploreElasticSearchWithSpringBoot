//package elasticsearch.demo.elasticsearch.services;
//
//
//import elasticsearch.demo.elasticsearch.model.Customer;
//import org.elasticsearch.index.query.QueryBuilder;
//import org.elasticsearch.index.query.QueryBuilders;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
//import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
//import org.springframework.stereotype.Service;
//
//@Service
//public class QueryDslService {
//
//    @Autowired
//    private ElasticsearchTemplate elasticsearchTemplate;
//
//    public SearchHits<Customer> searchMultiField(String firstname, int age) {
//        QueryBuilder query = QueryBuilders.boolQuery().must(QueryBuilders.matchQuery("firstname", firstname))
//                .must(QueryBuilders.matchQuery("age", age));
//        NativeSearchQuery nativeSearchQuery = new NativeSearchQueryBuilder().withQuery(query).build();
//        SearchHits<Customer> customers = elasticsearchTemplate.search(nativeSearchQuery, Customer.class);
////                queryForList(nativeSearchQuery, Customer.class);
//        return customers;
//    }
//}
