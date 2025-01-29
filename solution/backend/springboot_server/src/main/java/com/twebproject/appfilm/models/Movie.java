package com.twebproject.appfilm.models;

import java.sql.Date;
import java.util.List;

import com.twebproject.appfilm.models.filmactors.Actor;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;

/**
 * Represents a movie entity with various attributes.
 */
@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @Column(nullable = false)
    private Long id; // CSV "id"

    @Column(nullable = false, length = 255)
    private String name; // CSV "name"

    @Column(nullable = false)
    private Date date; // CSV "date" (mapped to SQL DATE type)

    @Column(length = 255)
    private String tagline; // CSV "tagline"

    @Column(columnDefinition = "TEXT")
    private String description; // CSV "description"

    private Double minute; // CSV "minute" (optional, so nullable)

    private Double rating; // CSV "rating" (optional, so nullable)

    @ManyToMany
    @JoinTable(
        name = "movie_actors",
        joinColumns = @JoinColumn(name = "movie_id"),
        inverseJoinColumns = {
            @JoinColumn(name = "actor_id"),
            @JoinColumn(name = "actor_name"),
            @JoinColumn(name = "actor_role")
        }
    )
    private List<Actor> actors;

    public Movie() {
        // Default constructor
    }

    public Movie(Long id, String name, Date date, String tagline, String description, Double minute, Double rating, List<Actor> actors) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
        this.actors = actors;
    }

    // Getters and setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getTagline() {
        return tagline;
    }

    public void setTagline(String tagline) {
        this.tagline = tagline;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getMinute() {
        return minute;
    }

    public void setMinute(Double minute) {
        this.minute = minute;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public List<Actor> getActors() {
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }
}
