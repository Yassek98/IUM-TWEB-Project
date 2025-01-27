package com.twebproject.appfilm.models.filmcountries;

import java.io.Serializable;
import java.util.Objects;

import jakarta.persistence.Embeddable;

/**
 * Represents the composite key for the FilmCountry entity.
 */
@Embeddable
public record FilmCountryId(
    Long filmId,
    String country
) implements Serializable {

    /**
     * Constructs a new FilmCountryId record.
     *
     * @param filmId the unique identifier of the film
     * @param country the name of the country
     */
    public FilmCountryId {
        // Default constructor is provided by the record
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmCountryId that)) return false;
        return Objects.equals(filmId, that.filmId)
            && Objects.equals(country, that.country);
    }

    @Override
    public int hashCode() {
        return Objects.hash(filmId, country);
    }
}