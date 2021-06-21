package elasticsearch.demo.elasticsearch.repository;

import elasticsearch.demo.elasticsearch.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    List<Customer> findByFirstname(String firstName);
}
