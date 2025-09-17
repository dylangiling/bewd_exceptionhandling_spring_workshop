package nl.han.se.cnp.bewd.controller;

import nl.han.se.cnp.bewd.domain.Movie;
import nl.han.se.cnp.bewd.exceptions.MovieNotFoundException;
import nl.han.se.cnp.bewd.repository.MovieList;
import nl.han.se.cnp.bewd.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

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

        if (movie != null) {
            return movie;
        } else {
            throw new MovieNotFoundException();
        }
    }

    @GetMapping("/{id}")
    public Movie getMovieByPathId(@PathVariable String id) {
        Movie movie = movieService.getMovieById(id);

        if (movie != null) {
            return movie;
        } else {
            throw new MovieNotFoundException();
        }
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler
    public ResponseEntity<String> handle(MovieNotFoundException ex) {
        return ResponseEntity.notFound().build();
    }
}
