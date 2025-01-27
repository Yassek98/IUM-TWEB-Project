package com.twebproject.appfilm.models.filmcountries;


import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.ForeignKey;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

/**
 * Represents the relationship between a film and a country.
 */
@Entity
@Table(name = "film_countries")
public class FilmCountry {

    @EmbeddedId
    private FilmCountryId id;

    @ManyToOne
    @MapsId("filmId")
    @JoinColumn(name = "film_id", foreignKey = @ForeignKey(name = "fk_filmcountry_movie"))
    private Movie movie; // riferimento all'entità Movie

    /**
     * Constructs a new FilmCountry entity.
     */
    public FilmCountry() {
    }

    /**
     * Gets the composite key of the FilmCountry entity.
     *
     * @return the composite key
     */
    public FilmCountryId getId() {
        return id;
    }

    /**
     * Sets the composite key of the FilmCountry entity.
     *
     * @param id the composite key
     */
    public void setId(FilmCountryId id) {
        this.id = id;
    }

    /**
     * Gets the movie associated with the FilmCountry entity.
     *
     * @return the movie
     */
    public Movie getMovie() {
        return movie;
    }

    /**
     * Sets the movie associated with the FilmCountry entity.
     *
     * @param movie the movie
     */
    public void setMovie(Movie movie) {
        this.movie = movie;
    }
}

