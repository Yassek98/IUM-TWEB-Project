package com.twebproject.appfilm.models.filmactors;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Represents the composite key for the FilmActor entity.
 */
@Embeddable
public record FilmActorId(
    Long filmId,
    String actorName,
    String role
) implements Serializable {

    /**
     * Constructs a new FilmActorId record.
     *
     * @param filmId the unique identifier of the film
     * @param actorName the name of the actor
     * @param role the role of the actor in the film
     */
    public FilmActorId {
        // Default constructor is provided by the record
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmActorId that)) return false;
        return Objects.equals(filmId, that.filmId)
            && Objects.equals(actorName, that.actorName)
            && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, actorName, role);
    }
}
