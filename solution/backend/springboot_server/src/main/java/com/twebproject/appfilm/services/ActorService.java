package com.twebproject.appfilm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twebproject.appfilm.models.filmactors.Actor;
import com.twebproject.appfilm.models.filmactors.ActorId;
import com.twebproject.appfilm.repositories.ActorRepository;

/**
 * Service class for managing film actors.
 */
@Service
public class ActorService {

    @Autowired
    private ActorRepository filmActorRepo;

    /**
     * Retrieves all film actors.
     *
     * @return a list of all film actors
     */
    public List<Actor> getAllFilmActors() {
        return filmActorRepo.findAll();
    }

    /**
     * Searches for film actors by actor name.
     *
     * @param name the actor name to search for
     * @return a list of film actors with names containing the specified string
     */
    public List<Actor> searchFilmActors(String name) {
        return filmActorRepo.findByIdName(name);
    }

    /**
     * Retrieves a film actor by film ID, actor name, and role.
     *
     * @param id the film ID
     * @param name the actor name
     * @param role the role
     * @return the film actor with the specified film ID, actor name, and role, or null if not found
     */
    public Actor getFilmActor(Long id, String name, String role) {
        return filmActorRepo.findById(new ActorId(id, name, role)).orElse(null);
    }
}
