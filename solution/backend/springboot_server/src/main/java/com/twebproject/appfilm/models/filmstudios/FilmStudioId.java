package com.twebproject.appfilm.models.filmstudios;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;
/**
 * Represents the composite primary key for the FilmStudio entity.
 */
@Embeddable
public record FilmStudioId(
        Long id,
        String studio
) implements Serializable {
    /**
     * Default constructor for FilmStudioId.
     */
    public FilmStudioId {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmStudioId that = (FilmStudioId) o;
        return Objects.equals(id, that.id) && Objects.equals(studio, that.studio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, studio);
    }
}
