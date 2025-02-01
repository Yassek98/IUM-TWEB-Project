package com.twebproject.appfilm.controllers;
import com.twebproject.appfilm.models.Actor;
import com.twebproject.appfilm.models.Movie;
import com.twebproject.appfilm.models.SearchResult;
import com.twebproject.appfilm.services.ActorService;
import com.twebproject.appfilm.services.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    @Autowired
    private ActorService actorService;

    @Autowired
    private MovieService movieService;

    @GetMapping
    public ResponseEntity<List<SearchResult>> search(@RequestParam String query) {
        List<SearchResult> results = new ArrayList<>();

        // Cerca i film
        List<Movie> movies = movieService.searchMovies(query);
        for (Movie movie : movies) {
            results.add(new SearchResult("movie", movie.getId(), movie.getName()));
        }

        // Cerca gli attori unici
        List<Actor> actors = actorService.searchUniqueActorsByName(query);
        for (Actor actor : actors) {
            results.add(new SearchResult("actor", actor.getId(), actor.getName())); // Ora l'ID è univoco
        }

        return ResponseEntity.ok(results);
    }
}
