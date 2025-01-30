package com.twebproject.appfilm.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.twebproject.appfilm.models.FilmCountry;

/**
 * Repository interface for accessing FilmCountry entities from the database.
 */
@Repository
public interface FilmCountryRepository extends JpaRepository<FilmCountry, Integer> {

    /**
     * Finds FilmCountry entities by country name containing the specified string, ignoring case.
     *
     * @param country the string to search for in country names
     * @return a list of FilmCountry entities with country names containing the specified string
     */
    List<FilmCountry> findByCountry(String country);
}