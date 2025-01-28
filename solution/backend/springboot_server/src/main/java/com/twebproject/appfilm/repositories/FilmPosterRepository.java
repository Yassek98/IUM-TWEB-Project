package com.twebproject.appfilm.repositories;

import com.twebproject.appfilm.models.filmcountries.FilmCountryId;
import com.twebproject.appfilm.models.filmposters.FilmPoster;
import com.twebproject.appfilm.models.filmposters.FilmPosterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;


/**
 * Repository interface for accessing FilmPoster entities from the database.
 */
@Repository
public interface FilmPosterRepository extends JpaRepository<FilmPoster, FilmPosterId> {

    /**
     * Finds a FilmPoster entity by the ID of the film.
     *
     * @param id the ID of the film
     * @return the FilmPoster entity associated with the specified film ID
     */
    @Query("SELECT fp FROM FilmPoster fp WHERE fp.id = :id")
    Optional<FilmPoster> findById(@Param("id") FilmPosterId id);
}

