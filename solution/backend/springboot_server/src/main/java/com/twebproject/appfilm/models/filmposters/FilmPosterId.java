package com.twebproject.appfilm.models.filmposters;

import com.twebproject.appfilm.models.filmcountries.FilmCountryId;

import java.io.Serializable;
import java.util.Objects;

public record FilmPosterId(
    Long id,
    String link
) implements Serializable {

    /**
     * Constructs a new FilmCountryId record.
     *
     * @param id the unique identifier of the film
     */
    public FilmPosterId {
        // Default constructor is provided by the record
    }


}
