package com.twebproject.appfilm.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twebproject.appfilm.models.Movie;
import com.twebproject.appfilm.repositories.MovieRepository;

/**
 * Service class for managing movies.
 */
@Service
public class MovieService {

    @Autowired
    private MovieRepository movieRepo;

    /**
     * Retrieves all movies.
     *
     * @return a list of all movies
     */
    public List<Movie> getAllMovies() {
        return movieRepo.findAll();
    }

    /**
     * Retrieves a movie by its ID.
     *
     * @param id the ID of the movie
     * @return the movie with the specified ID, or null if not found
     */
    public Movie getMovie(Integer id) {
        return movieRepo.findById(id).orElse(null);
    }

    /**
     * Searches for movies by name.
     *
     * @param name the name to search for
     * @return a list of movies with names containing the specified string
     */
    public List<Movie> searchMovies(String name) {
        return movieRepo.findByName(name);
    }
}
