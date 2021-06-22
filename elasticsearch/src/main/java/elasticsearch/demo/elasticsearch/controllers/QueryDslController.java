//package elasticsearch.demo.elasticsearch.controllers;
//
//import elasticsearch.demo.elasticsearch.model.Customer;
//import elasticsearch.demo.elasticsearch.services.QueryDslService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.data.elasticsearch.core.SearchHits;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//public class QueryDslController {
//
//    @Autowired
//    private QueryDslService queryDslService;
//
//    @GetMapping("/serachMultiField/{firstname}/{age}")
//    public SearchHits<Customer> serachByMultiField(@PathVariable String firstname, @PathVariable int age) {
//        return queryDslService.searchMultiField(firstname, age);
//    }
//}
