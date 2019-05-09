package com.theblackdre1d.semestralka.controllers;

import com.theblackdre1d.semestralka.forms.SearchMovieForm;
import com.theblackdre1d.semestralka.models.Movie;
import com.theblackdre1d.semestralka.repository.MovieRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class MovieController {

    private final Logger logger = LoggerFactory.getLogger(MovieController.class);

    @Autowired
    private MovieRepository repository;

    @RequestMapping(value = "/homescreen", method = RequestMethod.GET)
    public String homescreen() {
        return "index";
    }

    @RequestMapping(value = "/homescreen", method = RequestMethod.POST)
    public String homescreen(@ModelAttribute(name = "searchMovieForm")SearchMovieForm searchMovieForm, Model model) {
        final List<Movie> result = repository.findByName(searchMovieForm.getmMovieName());
        model.addAttribute("movies", result);
        logger.info("SEARCH RESULT:" + result.toString());
        return "index";
    }
}