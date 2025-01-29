package com.twebproject.appfilm.controllers;

import com.twebproject.appfilm.services.FilmStudioService;
import com.twebproject.appfilm.models.filmstudios.FilmStudio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/studios")
public class StudioController {
    @Autowired
    private FilmStudioService studioService;

    /**
     * Retrieves a list of studios associated with a given movie ID.
     *
     * @param id the ID of the movie
     * @return a list of studio names
     */
    @GetMapping("/{id}")
    public List<String> getStudiosOfFilm(@PathVariable Long id) {
        return studioService.getAllStudiosOfFilm(id)
                .stream()
                .map(FilmStudio::getStudio)
                .toList();
    }
}
