package Domain;

import java.lang.reflect.Array;
import java.util.List;
import java.util.ArrayList;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;

import java.util.Collections;
import java.util.Comparator;

import Data.MovieData;


public class Media{
    private final MovieData daAccess;
    List<Movie> movies;
    List<TVshow> tvShow;

    Media(String path) {
        daAccess = new MovieData(path);
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
    }

    private void insMedia() {
        for(String movieData : daAccess.loadData()) {

            String[] elements = movieData.split("; ");
            String title = elements[0];
            String releaseYear = elements[1];
            String genre = elements[2];
            String rating = elements[3].substring(0,elements[3].length());

            if(elements.length == 4) {
                movies.add(new Movie(title, releaseYear, genre, rating));
            } else if(elements.length == 5) {
                String episodes = elements[4];

                tvShow.add(new TVshow(title, releaseYear, genre, rating, episodes));
            }
        }

    }

    public static void main(String[] args) throws Exception {
        Media m = new Media("src/main/resources/Data/film.txt");
        Media t = new Media("src/main/resources/Data/serier.txt");
        m.insMedia();
        t.insMedia();

        Collections.sort(m.movies, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        File dir = new File("src/main/resources/Data/filmplakater");

        for (final File f : dir.listFiles()) {
            BufferedImage img = null;

            img = ImageIO.read(f);

            for(Movie movie : m.movies) {
                String x = movie.getName()+".jpg";

                if(x.equals(f.getName())) {
                    movie.setImagePath("src/main/resources/Data/filmplakater/"+f.getName());
                    break;
                }
            }
        }

        for(Movie movie : m.movies) {
            System.out.println(movie.toString());
        }


/*
        for(TVshow tvshow : t.tvShow) {
            System.out.println(tvshow.toString());
        }
        */

    }


}
