package com.twebproject.appfilm.repositories;

import com.twebproject.appfilm.models.FilmPoster;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Repository interface for accessing FilmPoster entities from the database.
 */
@Repository
public interface FilmPosterRepository extends JpaRepository<FilmPoster, Integer> {

    /**
     * Finds a FilmPoster entity by the ID of the film.
     *
     * @param id the ID of the film
     * @return the FilmPoster entity associated with the specified film ID
     */
  //  @Query("SELECT p FROM FilmPoster p WHERE p.id = :id")
    Optional<FilmPoster> findById(@Param("id") Integer id);
}

