package Domain;

import java.util.List;
import java.util.ArrayList;

import Data.MovieData;

public class Media{
    private MovieData daAccess;
    List<Movie> movies;
    List<TVshow> tvShow;

    Media() {
        daAccess = new MovieData("src/main/resources/Data/film.txt");
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
    }


}
