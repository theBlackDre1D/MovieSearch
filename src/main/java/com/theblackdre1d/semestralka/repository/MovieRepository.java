package com.theblackdre1d.semestralka.repository;

import com.theblackdre1d.semestralka.models.Movie;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface MovieRepository extends ElasticsearchRepository<Movie, String> {

    List<Movie> findByName(String name);
}
