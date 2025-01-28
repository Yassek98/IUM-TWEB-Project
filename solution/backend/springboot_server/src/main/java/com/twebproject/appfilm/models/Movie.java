package com.twebproject.appfilm.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Represents a movie entity with various attributes.
 */
@Entity
@Table(name = "movies")
public record Movie(
    @Id Long id,             // CSV "id"
    String name,             // CSV "name"
    Integer date,            // CSV "date"
    String tagline,          // CSV "tagline"
    String description,      // CSV "description"
    Integer minute,          // CSV "minute"
    Double rating            // CSV "rating"
) {
    /**
     * Constructs a new Movie record.
     *
     * @param id the unique identifier of the movie
     * @param name the name of the movie
     * @param date the release date of the movie
     * @param tagline the tagline of the movie
     * @param description the description of the movie
     * @param minute the duration of the movie in minutes
     * @param rating the rating of the movie
     */
}