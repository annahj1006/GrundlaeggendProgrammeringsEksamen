package Domain;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

import Data.MovieData;

public class Media{
    private final MovieData daAccess;
    List<Movie> movies;
    List<TVshow> tvShow;

    Media() {
        daAccess = new MovieData("src/main/resources/Data/serier.txt");
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
    }

    private void insMedia() {
        for(String movieData : daAccess.loadData()) {

            String[] elements = movieData.split("; ");
            for(String ele : elements){
                System.out.println(ele);
            }
            String title = elements[0];
            String releaseYear = elements[1];
            String genre = elements[2];
            String rating = elements[3].substring(0,elements[3].length()-1);
            System.out.println(title);
            if(elements.length == 4) {
                movies.add(new Movie(title, releaseYear, genre, rating));
            } else if(elements.length == 5) {
                String episodes = elements[4];

                tvShow.add(new TVshow(title, releaseYear, genre, rating, episodes));
            }
        }

    }

    public static void main(String[] args) {
        Media m = new Media();
        m.insMedia();
        /*for(Movie movie : m.movies) {
            System.out.println(movie.getName());

        }*/
        for(TVshow tvshow : m.tvShow) {
           System.out.println(tvshow.getName());

        }
    }


}
