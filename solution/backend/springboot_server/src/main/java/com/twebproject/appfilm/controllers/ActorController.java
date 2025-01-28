package com.twebproject.appfilm.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twebproject.appfilm.models.filmactors.Actor;
import com.twebproject.appfilm.services.ActorService;

/**
 * REST controller for managing film actors.
 */
@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService filmActorService;

    /**
     * Retrieves all film actors.
     *
     * @return a list of all film actors
     */
    @GetMapping
    public List<Actor> getAllFilmActors() {
        return filmActorService.getAllFilmActors();
    }

}
