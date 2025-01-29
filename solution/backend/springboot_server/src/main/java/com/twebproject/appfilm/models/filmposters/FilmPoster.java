package com.twebproject.appfilm.models.filmposters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.*;

@Entity
@Table(name = "posters")
public class FilmPoster {

    @EmbeddedId
    private FilmPosterId id;

    @ManyToOne
    @MapsId("id")
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_filmposter_movie"))
    @JsonIgnore
    private Movie movie;

    public FilmPoster() {}

    public FilmPoster(Movie movie, String link) {
        this.movie = movie;
        this.id = new FilmPosterId(movie.getId(), link);
    }

    public FilmPosterId getId() {
        return id;
    }

    public String getLink() {
        return id.link(); 
    }
}
