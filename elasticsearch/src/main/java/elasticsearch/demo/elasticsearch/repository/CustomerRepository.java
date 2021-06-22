package elasticsearch.demo.elasticsearch.repository;

import elasticsearch.demo.elasticsearch.model.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {
    List<Customer> findByFirstname(String firstName);

    List<Customer> findByFirstnameAndAge(String firstName, String age);
}
