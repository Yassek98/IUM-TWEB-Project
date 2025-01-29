package com.twebproject.appfilm.models.filmgenres;

import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public record FilmGenreId(
        Long id,
        String genre
) implements Serializable {

    /**
     * Constructs a new FilmGenreId record.
     *
     * @param id the unique identifier of the film
     */
    public FilmGenreId {
        // Default constructor is provided by the record
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FilmGenreId that = (FilmGenreId) o;
        return Objects.equals(id, that.id) && Objects.equals(genre, that.genre);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, genre);
    }
}
