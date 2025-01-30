/*package com.twebproject.appfilm.controllers;


import com.twebproject.appfilm.models.filmthemes.FilmTheme;
import com.twebproject.appfilm.services.FilmThemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/themes")
public class ThemeController {
    @Autowired
    private FilmThemeService themeService;

    
     * Retrieves themes by the movie ID.
     *
     * @param id the ID of the movie
     * @return a list of themes associated with the movie
     
    @GetMapping("/{id}")
    public List<String> getThemesOfFilm(@PathVariable Long id) {
        return themeService.getAllThemesOfFilm(id)
                .stream()
                .map(FilmTheme::getTheme)
                .toList();
    }
}
*/