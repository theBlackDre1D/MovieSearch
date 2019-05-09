package com.theblackdre1d.semestralka.controllers.rest;

import com.theblackdre1d.semestralka.forms.SearchMovieForm;
import com.theblackdre1d.semestralka.models.Movie;
import com.theblackdre1d.semestralka.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MovieRestController {

    @Autowired
    private MovieRepository repository;

    @PostMapping("/movie/add")
    public boolean addMovie(@RequestBody Movie movie) {
        try {
            repository.save(movie);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    @GetMapping("/movie/all")
    public Iterable<Movie> getAllMovies() {
        return repository.findAll();
    }

    @GetMapping("/movie/{name}")
    public List<Movie> findByName(@ModelAttribute(name = "searchMovieForm") SearchMovieForm form, Model model) {
        return repository.findByName(form.getmMovieName());
    }
}
