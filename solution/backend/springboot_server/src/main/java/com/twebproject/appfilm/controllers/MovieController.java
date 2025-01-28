package com.twebproject.appfilm.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twebproject.appfilm.models.Movie;
import com.twebproject.appfilm.services.MovieService;

/**
 * REST controller for managing movies.
 */
@RestController
@RequestMapping("/movies")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * Retrieves all movies.
     *
     * @return a list of all movies
     */
    @GetMapping
    public List<Movie> getAllMovies() {
        return movieService.getAllMovies();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id the ID of the movie
     * @return the movie with the specified ID, or null if not found
     */
    @GetMapping("/{id}")
    public Movie getMovie(@PathVariable Long id) {
        return movieService.getMovie(id);
    }

    /**
     * Searches for movies by name.
     *
     * @param name the name to search for
     * @return a list of movies with names containing the specified string
     */
    @GetMapping("/search")
    public List<Movie> searchMovies(@RequestParam String name) {
        return movieService.searchMovies(name);
    }
}
