package com.twebproject.appfilm.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import com.twebproject.appfilm.models.Movie;

/**
 * Repository interface for accessing Movie entities from the database.
 */
@Repository
public interface MovieRepository extends JpaRepository<Movie, Integer> {

    /**
     * Finds movies by name containing the specified string, ignoring case.
     *
     * @param name the string to search for in movie names
     * @return a list of movies with names containing the specified string
     */
    @Query("SELECT m FROM Movie m WHERE lower(m.name) LIKE lower(concat('%', :name, '%'))")
    List<Movie> findByName(String name);

    /**
     * Finds a movie by its ID.
     *
     * @param id the ID of the movie
     * @return the movie with the specified ID, or null if not found
     */
    @Override
    @Query("SELECT m FROM Movie m WHERE m.id = :id")
    Optional<Movie> findById(Integer id);
}
