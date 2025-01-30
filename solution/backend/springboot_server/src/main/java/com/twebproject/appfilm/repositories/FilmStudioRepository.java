package com.twebproject.appfilm.repositories;

import com.twebproject.appfilm.models.FilmStudio;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.Query;

/**
 * Repository interface for accessing FilmStudio entities from the database.
 */
@Repository
public interface FilmStudioRepository extends JpaRepository<FilmStudio, Integer> {

    /**
     * Finds all studios associated with a given movie ID.
     *
     * @param id the ID of the movie
     * @return a list of FilmStudio entities
     */
 //   @Query("SELECT s FROM FilmStudio s WHERE s.id = :id")
@Query("SELECT s FROM FilmStudio s WHERE s.movie.id = :id")
List<FilmStudio> findByMovieId(@Param("id") Integer id);
}