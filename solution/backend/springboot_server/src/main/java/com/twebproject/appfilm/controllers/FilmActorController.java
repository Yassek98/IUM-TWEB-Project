package com.twebproject.appfilm.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twebproject.appfilm.models.filmactors.FilmActor;
import com.twebproject.appfilm.services.FilmActorService;

/**
 * REST controller for managing film actors.
 */
@RestController
@RequestMapping("/film-actors")
public class FilmActorController {

    @Autowired
    private FilmActorService filmActorService;

    /**
     * Retrieves all film actors.
     *
     * @return a list of all film actors
     */
    @GetMapping
    public List<FilmActor> getAllFilmActors() {
        return filmActorService.getAllFilmActors();
    }

    /**
     * Retrieves a film actor by its composite ID.
     *
     * @param filmId the ID of the film
     * @param actorName the name of the actor
     * @param role the role of the actor in the film
     * @return the film actor with the specified composite ID, or null if not found
     */
    @GetMapping("/{filmId}/{actorName}/{role}")
    public FilmActor getFilmActor(@PathVariable Long filmId, @PathVariable String actorName, @PathVariable String role) {
        return filmActorService.getFilmActor(filmId, actorName, role);
    }
}
