package com.twebproject.appfilm.repositories;

import com.twebproject.appfilm.models.FilmGenre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository interface for accessing FilmPoster entities from the database.
 */
@Repository
public interface FilmGenreRepository extends JpaRepository<FilmGenre, Integer> {

    /**
     * Finds all genres of a film by film ID.
     *
     * @param filmId the ID of the film
     * @return a list of FilmGenre entities associated with the specified film ID
     */
    @Query("SELECT fg FROM FilmGenre fg WHERE fg.film.id = ?1")
    List<FilmGenre> findAllGenresOfFilm(Integer filmId);
}
