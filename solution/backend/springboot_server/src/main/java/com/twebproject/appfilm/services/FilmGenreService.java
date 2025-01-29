package com.twebproject.appfilm.services;

import com.twebproject.appfilm.models.filmgenres.FilmGenre;
import com.twebproject.appfilm.models.filmgenres.FilmGenreId;
import com.twebproject.appfilm.models.filmposters.FilmPoster;
import com.twebproject.appfilm.models.filmposters.FilmPosterId;
import com.twebproject.appfilm.repositories.FilmGenreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilmGenreService {

    @Autowired
    private FilmGenreRepository genreRepo;

    /**
     * Retrieves all genres of a film by its movie ID.
     *
     * @param id the ID of the movie
     * @return a list of genres associated with the movie
     */
    public List<FilmGenre> getAllGenreOfFIlm(Long id) {
        return genreRepo.findAllGenresOfFilm(id);
    }

}
