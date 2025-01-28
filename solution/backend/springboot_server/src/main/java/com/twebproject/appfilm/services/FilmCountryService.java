package com.twebproject.appfilm.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.twebproject.appfilm.models.filmcountries.FilmCountry;
import com.twebproject.appfilm.repositories.FilmCountryRepository;
import com.twebproject.appfilm.models.filmcountries.FilmCountryId;

/**
 * Service class for managing film countries.
 */
@Service
public class FilmCountryService {

    @Autowired
    private FilmCountryRepository filmCountryRepo;

    /**
     * Retrieves all film countries.
     *
     * @return a list of all film countries
     */
    public List<FilmCountry> getAllFilmCountries() {
        return filmCountryRepo.findAll();
    }

    /**
     * Searches for film countries by country name.
     *
     * @param country the country name to search for
     * @return a list of film countries with names containing the specified string
     */
    public List<FilmCountry> searchFilmCountries(String country) {
        return filmCountryRepo.findByIdCountry(country);
    }

    /**
     * Retrieves a film country by film ID and country name.
     *
     * @param filmId the film ID
     * @param country the country name
     * @return the film country with the specified film ID and country name, or null if not found
     */
    public FilmCountry getFilmCountry(Long filmId, String country) {
        return filmCountryRepo.findById(new FilmCountryId(filmId, country)).orElse(null);
    }
}
