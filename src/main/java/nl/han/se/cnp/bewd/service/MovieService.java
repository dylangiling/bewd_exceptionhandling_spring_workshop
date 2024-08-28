package nl.han.se.cnp.bewd.service;

import nl.han.se.cnp.bewd.domain.Movie;
import nl.han.se.cnp.bewd.repository.MovieList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {
    private MovieList movieList;

    @Autowired
    public MovieService(MovieList movieList) {
        this.movieList = movieList;
    }

    public MovieList getMovieList() {
        return movieList;
    }

    public Movie getMovieById(String movieId) {
        return movieList.findMovieById(movieId);
    }
}
