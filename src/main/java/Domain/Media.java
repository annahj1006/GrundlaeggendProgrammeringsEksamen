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
    public List<Movie> movies;
    public List<TVshow> tvShow;

    public Media(String dataPath, String imagePath) {
        daAccess = new MovieData(dataPath, imagePath);
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
    }

    public void instanziateMedia() {
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
        Collections.sort(movies, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        // skal sortere arraylisten med billeder
        int i = 0;
        for(String poster : daAccess.loadImageData()) {
            movies.get(i).setImagePath(poster);
            i++;
        }
    }


}
