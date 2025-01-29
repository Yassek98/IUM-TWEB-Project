package com.twebproject.appfilm.repositories;


import com.twebproject.appfilm.models.filmthemes.FilmTheme;
import com.twebproject.appfilm.models.filmthemes.FilmThemeId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FilmThemeRepository extends JpaRepository<FilmTheme, FilmThemeId> {
    /**
     * Finds all themes of a film by its movie ID.
     *
     * @param id the ID of the movie
     * @return a list of themes associated with the movie
     */

    @Query("SELECT t FROM FilmTheme t WHERE t.id.id = :id")
    List<FilmTheme> findAllThemesOfFilm(@Param("id") Long id);
}
