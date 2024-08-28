package nl.han.se.cnp.bewd.controller;

import nl.han.se.cnp.bewd.domain.Movie;
import nl.han.se.cnp.bewd.repository.MovieList;
import nl.han.se.cnp.bewd.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/movies")
public class MovieController {
    private final MovieService movieService;

    @Autowired
    public MovieController(MovieService movieService) {
        this.movieService = movieService;
    }

    @GetMapping
    public MovieList getAllMovies() {
        return movieService.getMovieList();
    }

    @GetMapping("/")
    public Movie getMovieById(@RequestParam("id") String id) {

            Movie movie = movieService.getMovieById(id);
            return movie;
    }
}
