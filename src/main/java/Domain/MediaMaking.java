package Domain;

import java.util.List;
import java.util.ArrayList;

import java.util.Collections;

import Data.MovieData;


public class MediaMaking{
    private final MovieData daAccess;
    public List<Media> movies;
    public List<Media> tvShow;



    public MediaMaking(String dataPath, String imagePath) {
        daAccess = new MovieData(dataPath, imagePath);
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
    }

    public void instanziateMedia() {
        List<String> posters = daAccess.loadImageData();
        List<String> media = daAccess.loadData();
        int i = 0;
        int j = 0;

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
                Media temp = new Media("movie", title, releaseYear, genre, rating, poster);
                movies.add(temp);

                j = 4;
            } else if(elements.length == 5) {
                Media temp = new Media("tvShow", title, releaseYear, genre, rating, poster);
                temp.setEpisodes(elements[4]);
                tvShow.add(temp);


            }
            i++;
        }
    }


}
