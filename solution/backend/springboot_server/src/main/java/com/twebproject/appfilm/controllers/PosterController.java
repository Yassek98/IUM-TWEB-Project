package com.twebproject.appfilm.controllers;

import com.twebproject.appfilm.models.FilmPoster;
import com.twebproject.appfilm.services.FilmPosterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posters")
public class PosterController {
    @Autowired
    private FilmPosterService posterService;

    /**
     * Retrieves a poster by its ID.
     *
     * @param id the ID of the movie associated with the poster
     * @return the poster associated with the movie, or null if not found
     */
    @GetMapping("/{id}")
    public ResponseEntity<String> getPoster(@PathVariable Integer id) {
        FilmPoster poster = posterService.getPoster(id);
        return (poster != null) ? ResponseEntity.ok(poster.getLink()) : ResponseEntity.notFound().build();
    }
}
