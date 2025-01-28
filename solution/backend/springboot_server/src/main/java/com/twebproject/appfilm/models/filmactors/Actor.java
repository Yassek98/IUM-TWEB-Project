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
@Table(name = "actors")
public class Actor {

    @EmbeddedId
    private ActorId id; // Updated composite key

    @ManyToOne
    @MapsId("id") // Updated field reference
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_filmactor_movie"))
    private Movie movie;

    public Actor() {}

    public ActorId getId() {
        return id;
    }

    public void setId(ActorId id) {
        this.id = id;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}
