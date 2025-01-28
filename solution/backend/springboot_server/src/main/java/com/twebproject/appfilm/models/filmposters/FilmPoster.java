package com.twebproject.appfilm.models.filmposters;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.twebproject.appfilm.models.Movie;
import jakarta.persistence.*;

@Entity
@Table(name = "posters")
public class FilmPoster {

    @EmbeddedId
    private FilmPosterId id; // Updated composite key

    @ManyToOne
    @MapsId("id") // Updated field reference
    @JoinColumn(name = "id", foreignKey = @ForeignKey(name = "fk_filmposter_movie"))
    @JsonIgnore
    private Movie movie;

    @Column(length = 2083)
    private String link;

    /**
     * Default constructor for FilmPoster.
     */
    public FilmPoster() {
    }

    /**
     * Gets the ID of the film poster.
     *
     * @return the ID of the film poster
     */
    public FilmPosterId getId() {
        return id;
    }

    /**
     * Sets the ID of the film poster.
     *
     * @param id the ID to set
     */
    public void setId(FilmPosterId id) {
        this.id = id;
    }

    /**
     * Gets the link of the film poster.
     *
     * @return the link of the film poster
     */
    public String getLink() {
        return link;
    }

    /**
     * Sets the link of the film poster.
     *
     * @param link the link to set
     */
    public void setLink(String link) {
        this.link = link;
    }
}
