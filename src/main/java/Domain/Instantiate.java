package Domain;

import Data.MediaData;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;




public class Instantiate {
    protected List<Media> movies;
    protected List<Media> tvShow;
    protected List<Media> mix;
    protected List<String> genreList;

    // The Instantiate class' constructor gets the data and posters from both 'film'
    // and 'serier' and passes it along to the instantiateMedia function.
    // Which then return to lists one with movie objects and one with series objects
    // After data and posters have been made into objects, we make a list with
    protected Instantiate() throws FileNotFoundException {

        //movies = new ArrayList<>();
        //tvShow = new ArrayList<>();

        movies = instantiateMedia(new MediaData("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater"));
        tvShow = instantiateMedia(new MediaData("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider"));

        mix = getCombinedMediaList();
        genreList = instantiateGenre();
    }

    // instantiateMedia takes a MediaData object as an argument and
    // gets all the relevant data from the given MediaData(from the providede paths) and stores them as objects.
    private List<Media> instantiateMedia(MediaData data) throws FileNotFoundException {
        List<Media> tempList = new ArrayList<>();

        List<String> posters = data.loadImageData();
        List<String> media = data.loadData();
        int i = 0;

        // Sorting our lists alphabetically
        Collections.sort(posters);
        Collections.sort(media, (p1, p2) -> p1.substring(0,p1.indexOf("; ")).compareTo(p2.substring(0,p2.indexOf("; "))));


        // Makes objects from the string of data given from the MediaData object
        for(String mediaData : media) {
            // Splitting our movie data and storing it in separate variables for easier readability
            String[] elements = mediaData.split(";");

            String title = elements[0];
            String releaseYear = elements[1].substring(1, elements[1].length());
            String genre = elements[2].substring(1, elements[2].length());
            String poster = posters.get(i);
            String rating = elements[3].substring(1,elements[3].length());

            // Making movies and tv-show objects and adding them to their respective lists
            if(elements.length == 4) {
                Media tempObj = new Movie("movie", title, releaseYear, genre, rating, poster);
                tempList.add(tempObj);
            } else if(elements.length == 5) {
                Media tempObj = new TVshow("tvShow", title, releaseYear, genre, rating, poster, elements[4].substring(1, elements[4].length()));
                tempList.add(tempObj);
            }
            i++;
        }
        return tempList;
    }

    // returns the combined list of both movies and series
    private List<Media> getCombinedMediaList() {
        List<Media> temp = new ArrayList<>();
        for(Media movie : movies) {
            temp.add(movie);
        }
        for(Media tvShow : tvShow) {
            temp.add(tvShow);
        }
        /*for(Media media : temp) {
            Collections.sort(temp, (p1, p2) -> p1.getName().compareTo(p2.getName()));
        }*/
        return temp;
    }

    // returns a list of all unique genres
    private List<String> instantiateGenre() {
        List<String> temp = new ArrayList<>();

        for(Media m : mix) {
            String[] genreArray = m.getGenre().split(", ");
            for(String genre : genreArray) {
                if(!(temp.contains(genre))) {
                    temp.add(genre.toLowerCase());
                }
            }
        }
        return temp;
    }

}
