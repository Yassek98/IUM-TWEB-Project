package com.twebproject.appfilm.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.twebproject.appfilm.models.filmactors.Actor;
import com.twebproject.appfilm.models.filmactors.ActorId;
import com.twebproject.appfilm.services.ActorService;

/**
 * REST controller for managing actors.
 */
@RestController
@RequestMapping("/actors")
public class ActorController {

    @Autowired
    private ActorService actorService;

    /**
     * Retrieves all actors.
     *
     * @return a list of all actors
     */
    @GetMapping
    public ResponseEntity<List<Actor>> getAllActors(@RequestParam(value = "limit", required = false) Integer limit) {
        try {
            List<Actor> actors = actorService.getAllActors();
            if (limit != null && limit > 0 && limit < actors.size()) {
                actors = actors.subList(0, limit);
            }
            return ResponseEntity.ok(actors);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }

    /**
     * Searches for actors by name.
     *
     * @param name the name to search for
     * @return a list of actors with names containing the specified string
     */
    @GetMapping("/search")
    public List<Actor> searchActors(@RequestParam String name) {
        return actorService.searchActors(name);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Actor> getActorById(@PathVariable ActorId id) {
        try {
            Actor actor = actorService.getActorById(id);
            if (actor == null) {
                return ResponseEntity.status(404).body(null);
            }
            return ResponseEntity.ok(actor);
        } catch (Exception e) {
            return ResponseEntity.status(500).body(null);
        }
    }
}
