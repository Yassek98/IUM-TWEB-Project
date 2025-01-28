package com.twebproject.appfilm.models.filmposters;

import com.twebproject.appfilm.models.filmcountries.FilmCountryId;

import java.io.Serializable;
import java.util.Objects;

public record FilmPosterId(
    Long id
) implements Serializable {

    /**
     * Constructs a new FilmCountryId record.
     *
     * @param id the unique identifier of the film
     */
    public FilmPosterId {
        // Default constructor is provided by the record
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof FilmPosterId that)) return false;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
