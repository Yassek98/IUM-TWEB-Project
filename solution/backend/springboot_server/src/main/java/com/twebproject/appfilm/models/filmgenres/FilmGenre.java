package com.twebproject.appfilm.models.filmgenres;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.*;
@Entity
@Table(name = "genres")
public class FilmGenre {

    @EmbeddedId
    private FilmGenreId id;

    @ManyToOne
    //@MapsId("id")
    @JoinColumn(name = "id", insertable = false, updatable = false)
    @JsonIgnore
    private Movie movie;

    /**
     * Default constructor for FilmGenre.
     */
    public FilmGenre() {}

    /**
     * Constructs a FilmGenre with the specified movie and genre.
     *
     * @param movie the movie associated with the genre
     * @param genre the genre of the movie
     */
    public FilmGenre(Movie movie, String genre) {
        this.movie = movie;
        this.id = new FilmGenreId(movie.getId(), genre);
    }

    /**
     * Gets the composite ID of the FilmGenre.
     *
     * @return the composite ID of the FilmGenre
     */
    public FilmGenreId getId() {
        return id;
    }

    /**
     * Gets the genre of the FilmGenre.
     *
     * @return the genre of the FilmGenre
     */
    public String getGenre() {
        return id.genre();
    }
}
