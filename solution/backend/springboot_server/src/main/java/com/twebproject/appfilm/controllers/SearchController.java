package com.twebproject.appfilm.controllers;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.twebproject.appfilm.models.Movie;
import com.twebproject.appfilm.services.MovieService;

/**
 * Controller for handling search operations.
 */
@RestController
@RequestMapping("/api")
public class SearchController {

    @Autowired
    private MovieService movieService;

    /**
     * Search for movies by their name.
     *
     * @param name the name of the movie to search for
     * @return a ResponseEntity containing the list of movies or a not found status
     */
    @GetMapping("/search")
    public ResponseEntity<List<Movie>> searchMovies(@RequestParam(name = "query") String name) {
        List<Movie> movies = movieService.searchMovies(name);
        if (movies.isEmpty()) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.ok(movies);
    }
}
