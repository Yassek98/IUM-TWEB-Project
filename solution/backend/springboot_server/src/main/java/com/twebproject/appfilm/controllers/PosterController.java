package com.twebproject.appfilm.controllers;

import com.twebproject.appfilm.models.filmposters.FilmPoster;
import com.twebproject.appfilm.services.FilmPosterService;
import org.springframework.beans.factory.annotation.Autowired;
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
    public FilmPoster getPoster(@PathVariable Long id) {
        return posterService.getPoster(id);
    }
}
