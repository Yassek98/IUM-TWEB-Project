package com.twebproject.appfilm.models.filmthemes;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.*;

/**
 * Represents a theme associated with a movie.
 */
@Entity
@Table(name = "themes")
public class FilmTheme {

    @EmbeddedId
    private FilmThemeId id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_filmthemes_movie"))
    @JsonIgnore
    private Movie movie;

    /**
     * Gets the composite primary key of the FilmTheme.
     *
     * @return the FilmThemeId
     */
    public FilmThemeId getId() {
        return id;
    }

    /**
     * Sets the composite primary key of the FilmTheme.
     *
     * @param id the FilmThemeId to set
     */
    public void setId(FilmThemeId id) {
        this.id = id;
    }

    /**
     * Gets the theme name.
     *
     * @return the theme name
     */
    public String getTheme() {
        return id.theme();
    }

}
