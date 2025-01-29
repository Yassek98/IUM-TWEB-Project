package com.twebproject.appfilm.models.filmstudios;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.*;

/**
 * Represents a studio associated with a movie.
 */
@Entity
@Table(name = "studios")
public class FilmStudio {

    @EmbeddedId
    private FilmStudioId id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_filmstudios_movie"))
    @JsonIgnore
    private Movie movie;

    /**
     * Gets the composite primary key of the FilmStudio.
     *
     * @return the FilmStudioId
     */
    public FilmStudioId getId() {
        return id;
    }

    /**
     * Sets the composite primary key of the FilmStudio.
     *
     * @param id the FilmStudioId to set
     */
    public void setId(FilmStudioId id) {
        this.id = id;
    }

    /**
     * Gets the name of the studio.
     *
     * @return the studio name
     */
    public String getStudio() {
        return id.studio();
    }

}
