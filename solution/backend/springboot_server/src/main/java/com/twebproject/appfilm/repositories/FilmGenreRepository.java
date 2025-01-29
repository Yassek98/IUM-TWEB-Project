package com.twebproject.appfilm.repositories;

import com.twebproject.appfilm.models.Movie;
import com.twebproject.appfilm.models.filmgenres.FilmGenre;
import com.twebproject.appfilm.models.filmgenres.FilmGenreId;
import com.twebproject.appfilm.models.filmposters.FilmPoster;
import com.twebproject.appfilm.models.filmposters.FilmPosterId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

/**
 * Repository interface for accessing FilmPoster entities from the database.
 */
@Repository
public interface FilmGenreRepository extends JpaRepository<FilmGenre, FilmGenreId> {


    /**
     * Finds all genres of a film by its movie ID.
     *
     * @param id the ID of the movie
     * @return a list of genres associated with the movie
     */
    @Query("SELECT g FROM FilmGenre g WHERE g.id.id = :id")
    List<FilmGenre> findAllGenresOfFilm(@Param("id") Long id);
}
