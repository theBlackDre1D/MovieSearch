package com.theblackdre1d.semestralka.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

@Document(indexName = "semestralka_app", type = "movie")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Movie {

    @Id
    public String id;
    public String name;
    public String homepage;
    public String genre;
    public Double popularity;
    public Integer budget;
    public Double raiting;
    public String releaseDate;
}
