package com.twebproject.appfilm.models.filmactors;

import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Represents the relationship between a film and an actor.
 */
@Entity
@Table(name = "film_actors")
public class FilmActor {

    @EmbeddedId
    private FilmActorId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_filmactor_movie"))
    private Movie movie; // riferimento all'entità Movie

    /**
     * Constructs a new FilmActor entity.
     */
    public FilmActor() {
    }

    /**
     * Gets the composite key of the FilmActor entity.
     *
     * @return the composite key
     */
    public FilmActorId getId() {
        return id;
    }

    /**
     * Sets the composite key of the FilmActor entity.
     *
     * @param id the composite key
     */
    public void setId(FilmActorId id) {
        this.id = id;
    }

    /**
     * Gets the movie associated with the FilmActor entity.
     *
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie associated with the FilmActor entity.
     *
     * @param movie the movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

