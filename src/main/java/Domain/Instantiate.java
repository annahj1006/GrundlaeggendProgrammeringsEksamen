package Domain;

import Data.MovieData;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;




public class Instantiate {
    private final MovieData daAccess;
    private List<Media> movies;
    private List<Media> tvShow;
    private List<Media> mix;



    public Instantiate(String dataPath, String imagePath) {
        daAccess = new MovieData(dataPath, imagePath);
        movies = new ArrayList<>();
        tvShow = new ArrayList<>();
        mix = new ArrayList<>();
    }

    public void instantiateMedia() {
        List<String> posters = daAccess.loadImageData();
        List<String> media = daAccess.loadData();
        int i = 0;

        // Sorting our lists alphabetically
        Collections.sort(posters);
        Collections.sort(media, (p1, p2) -> p1.substring(0,p1.indexOf("; ")).compareTo(p2.substring(0,p2.indexOf("; "))));



        for(String mediaData : media) {
            // Splitting our movie data and storing it in separate variables for easier readability
            String[] elements = mediaData.split(";");

            String title = elements[0];
            String releaseYear = elements[1].substring(1, elements[1].length());
            String genre = elements[2].substring(1, elements[2].length());
            String poster = posters.get(i);
            String rating = elements[3].substring(1,elements[3].length());


            // Making movies and tv-show objects and adding them to their separate lists
            if(elements.length == 4) {
                Media temp = new Media("movie", title, releaseYear, genre, rating, poster);
                movies.add(temp);
            } else if(elements.length == 5) {
                Media temp = new Media("tvShow", title, releaseYear, genre, rating, poster);
                temp.setEpisodes(elements[4].substring(1, elements[4].length()));
                tvShow.add(temp);
            }
            i++;
        }
    }

    public List<Media> combinedMediaList() {
        List<Media> temp = new ArrayList<>();
        for(Media movie : getMovies()) {
            temp.add(movie);
        }
        for(Media tvShow : getTvShow()) {
            temp.add(tvShow);
        }
        return temp;
    }
    public void instantiateGenre() {
        List<String> genre = new ArrayList<>();

        for(Media m : mix) {
            String[] s = m.getGenre().split(", ");
            for(String sx : s) {
                if(!(genre.contains(sx))) {
                    genre.add(sx);
                }
            }
        }
    }


    public List<Media> getMovies() {
        return movies;
    }
    public List<Media> getTvShow() {
        return tvShow;
    }
}
