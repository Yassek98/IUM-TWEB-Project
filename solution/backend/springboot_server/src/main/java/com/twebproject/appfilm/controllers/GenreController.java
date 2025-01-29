package com.twebproject.appfilm.controllers;

import com.twebproject.appfilm.models.filmgenres.FilmGenre;
import com.twebproject.appfilm.services.FilmGenreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/genres")
public class GenreController {
    @Autowired
    private FilmGenreService genreService;

    /**
     * Retrieves genres by the movie ID.
     *
     * @param id the ID of the movie
     * @return a list of genres associated with the movie
     */
    @GetMapping("/{id}")
    public List<String> getGenresOfFilm(@PathVariable Long id) {
        return genreService.getAllGenreOfFIlm(id)
                .stream()
                .map(FilmGenre::getGenre)
                .distinct()
                .collect(Collectors.toList());
    }
}
