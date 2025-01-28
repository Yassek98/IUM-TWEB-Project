package com.twebproject.appfilm.services;

import com.twebproject.appfilm.models.filmposters.FilmPoster;
import com.twebproject.appfilm.models.filmposters.FilmPosterId;
import com.twebproject.appfilm.repositories.FilmPosterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Service class for managing posters.
 */
@Service
public class FilmPosterService {

    @Autowired
    private FilmPosterRepository posterRepo;

    /**
     * Retrieves a poster by its ID.
     *
     * @param id the ID of the movie associated with the poster
     * @return the poster associated with the movie, or null if not found
     */
    public FilmPoster getPoster(Long id) {
        return posterRepo.findById(new FilmPosterId(id)).orElse(null);
    }
}
