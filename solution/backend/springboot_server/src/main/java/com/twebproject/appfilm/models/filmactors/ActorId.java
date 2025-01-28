package com.twebproject.appfilm.models.filmactors;

import java.io.Serializable;
import java.util.Objects;
import jakarta.persistence.Embeddable;

/**
 * Represents the composite key for the Actor entity.
 */
@Embeddable
public record ActorId(
    Long id,               // Updated from filmId
    String name,           // Updated from actorName
    String role
) implements Serializable {

    public ActorId {
        // Default constructor is provided by the record
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ActorId that)) return false;
        return Objects.equals(id, that.id)
            && Objects.equals(name, that.name)
            && Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, role);
    }
}
