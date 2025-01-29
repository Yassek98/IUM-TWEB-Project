package com.twebproject.appfilm.repositories;

import com.twebproject.appfilm.models.filmstudios.FilmStudio;
import com.twebproject.appfilm.models.filmstudios.FilmStudioId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing FilmStudio entities from the database.
 */
@Repository
public interface FilmStudioRepository extends JpaRepository<FilmStudio, FilmStudioId> {

    /**
     * Finds all studios associated with a given movie ID.
     *
     * @param id the ID of the movie
     * @return a list of FilmStudio entities
     */
    @Query("SELECT s FROM FilmStudio s WHERE s.id.id = :id")
    List<FilmStudio> findAllStudiosOfFilm(@Param("id") Long id);
}
