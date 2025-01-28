package com.twebproject.appfilm.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twebproject.appfilm.models.filmactors.FilmActor;
import com.twebproject.appfilm.models.filmactors.FilmActorId;
import com.twebproject.appfilm.repositories.FilmActorRepository;

/**
 * Service class for managing film actors.
 */
@Service
public class FilmActorService {

    @Autowired
    private FilmActorRepository filmActorRepo;

    /**
     * Retrieves all film actors.
     *
     * @return a list of all film actors
     */
    public List<FilmActor> getAllFilmActors() {
        return filmActorRepo.findAll();
    }

    /**
     * Searches for film actors by actor name.
     *
     * @param actorName the actor name to search for
     * @return a list of film actors with names containing the specified string
     */
    public List<FilmActor> searchFilmActors(String actorName) {
        return filmActorRepo.findByIdActorName(actorName);
    }

    /**
     * Retrieves a film actor by film ID, actor name, and role.
     *
     * @param filmId the film ID
     * @param actorName the actor name
     * @param role the role
     * @return the film actor with the specified film ID, actor name, and role, or null if not found
     */
    public FilmActor getFilmActor(Long filmId, String actorName, String role) {
        return filmActorRepo.findById(new FilmActorId(filmId, actorName, role)).orElse(null);
    }
}
