package com.twebproject.appfilm.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import java.sql.Date;

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

    public Movie() {
        // Default constructor
    }

    public Movie(Long id, String name, Date date, String tagline, String description, Double minute, Double rating) {
        this.id = id;
        this.name = name;
        this.date = date;
        this.tagline = tagline;
        this.description = description;
        this.minute = minute;
        this.rating = rating;
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
}
