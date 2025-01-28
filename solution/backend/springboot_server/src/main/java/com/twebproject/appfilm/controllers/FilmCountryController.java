package com.twebproject.appfilm.controllers;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.twebproject.appfilm.models.filmcountries.FilmCountry;
import com.twebproject.appfilm.services.FilmCountryService;

/**
 * REST controller for managing film countries.
 */
@RestController
@RequestMapping("/film-countries")
public class FilmCountryController {

    @Autowired
    private FilmCountryService filmCountryService;

    /**
     * Retrieves all film countries.
     *
     * @return a list of all film countries
     */
    @GetMapping
    public List<FilmCountry> getAllFilmCountries() {
        return filmCountryService.getAllFilmCountries();
    }

    /**
     * Retrieves a film country by its composite ID.
     *
     * @param filmId the ID of the film
     * @param country the name of the country
     * @return the film country with the specified composite ID, or null if not found
     */
    @GetMapping("/{filmId}/{country}")
    public FilmCountry getFilmCountry(@PathVariable Long filmId, @PathVariable String country) {
        return filmCountryService.getFilmCountry(filmId, country);
    }
}
