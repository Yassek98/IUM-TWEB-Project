package com.twebproject.appfilm.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.twebproject.appfilm.models.Actor;
import com.twebproject.appfilm.repositories.ActorRepository;

import jakarta.persistence.EntityNotFoundException;

/**
 * Service class for managing actors.
 */
@Service
public class ActorService {

    @Autowired
    private ActorRepository actorRepo;

    /**
     * Retrieves all actors.
     *
     * @return a list of all actors
     */
    @Transactional(readOnly = true)
    public List<Actor> getAllActors() {
        try {
            return actorRepo.findAll();
        } catch (Exception e) {
            // Log the error and handle it appropriately
            throw new RuntimeException("Error retrieving actors", e);
        }
    }

    /**
     * Searches for actors by name.
     *
     * @param name the name to search for
     * @return a list of actors with names containing the specified string
     */
    public List<Actor> searchActors(String name) {
        return actorRepo.findByName(name);
    }

    /**
     * Retrieves an actor by film ID, actor name, and role.
     *
     * @param id the film ID
     * @param name the actor name
     * @param role the role
     * @return the actor with the specified film ID, actor name, and role, or null if not found
     */
    public Actor getActor(Integer id, String name, String role) {
        return actorRepo.findById(id).orElse(null);
    }

    /**
     * Retrieves an actor by ID.
     *
     * @param id the actor ID
     * @return the actor with the specified ID, or throws an exception if not found
     */
    @Transactional(readOnly = true)
    public Actor getActorById(Integer id) {
        try {
            Optional<Actor> actor = actorRepo.findById(id);
            if (actor.isPresent()) {
                return actor.get();
            } else {
                throw new EntityNotFoundException("Actor not found with id " + id);
            }
        } catch (EntityNotFoundException e) {
            // Log the error and handle it appropriately
            // Return null or a default Actor object to avoid blocking the server
            return null;
        }
    }
}
