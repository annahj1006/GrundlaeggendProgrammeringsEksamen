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
    public List<MediaController> movies;
    public List<MediaController> tvShow;
    public List<MediaController> mix;


    public Media(String dataPath, String imagePath) {
        daAccess = new MovieData(dataPath, imagePath);
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
        mix = new ArrayList<>();
    }

    public void instanziateMedia() {
        List<String> posters = daAccess.loadImageData();
        List<String> media = daAccess.loadData();
        int i = 0;

        // Sorting our lists alphabetically
        Collections.sort(posters);
        Collections.sort(media, (p1, p2) -> p1.substring(0,p1.indexOf("; ")).compareTo(p2.substring(0,p2.indexOf("; "))));



        for(String movieData : media) {

            // Splitting our movie data and storing it in separate variables for easier readability
            String[] elements = movieData.split("; ");

            String title = elements[0];
            String releaseYear = elements[1];
            String genre = elements[2];
            String poster = posters.get(i);
            String rating = elements[3].substring(0,elements[3].length());


            // Making movies and tvshow objects and adding them to their separate lists
            if(elements.length == 4) {
                MediaController temp = new MediaController("movie", title, releaseYear, genre, rating, poster);
                movies.add(temp);
                mix.add(temp);
            } else if(elements.length == 5) {
                MediaController temp = new MediaController("tvShow", title, releaseYear, genre, rating, poster);
                temp.setEpisodes(elements[4]);
                tvShow.add(temp);
                mix.add(temp);
            }
            i++;
        }

    }
}
