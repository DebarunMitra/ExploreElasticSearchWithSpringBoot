package com.esExampleTwo.studentDataElasticsearchEx.repository;

import com.esExampleTwo.studentDataElasticsearchEx.model.Student;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface StudentRepository extends ElasticsearchRepository<Student, String> {
}
