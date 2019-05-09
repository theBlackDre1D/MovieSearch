package com.theblackdre1d.semestralka.repository;

import com.theblackdre1d.semestralka.models.Customer;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface CustomerRepository extends ElasticsearchRepository<Customer, String> {

    List<Customer> findByFirstName(String firstName);
}
