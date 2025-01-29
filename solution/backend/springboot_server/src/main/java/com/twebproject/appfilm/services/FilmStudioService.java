package com.twebproject.appfilm.services;

import com.twebproject.appfilm.models.filmstudios.FilmStudio;
import com.twebproject.appfilm.repositories.FilmStudioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service class for handling FilmStudio-related operations.
 */
@Service
public class FilmStudioService {

    @Autowired
    private FilmStudioRepository studioRepo;

    /**
     * Retrieves all studios associated with a given movie ID.
     *
     * @param id the ID of the movie
     * @return a list of FilmStudio entities
     */
    public List<FilmStudio> getAllStudiosOfFilm(Long id) {
        return studioRepo.findAllStudiosOfFilm(id);
    }
}

