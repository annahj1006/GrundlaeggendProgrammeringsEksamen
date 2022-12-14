package Domain;

import Data.MediaData;

import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
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
            Map<String, String> tempMap = new HashMap<>();

            if(mediaData.charAt(mediaData.length()-1) == ' ') {
                mediaData = mediaData.substring(0, mediaData.length()-2);
            }

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
                String temp = elements[4].replace(",","-");
                temp = temp.replace(" ", "");
                String[] seriesEpisodes = temp.split("-");

                for(int j  = 0; j < seriesEpisodes.length; j++) {
                    tempMap.put(seriesEpisodes[j], seriesEpisodes[++j]);
                }

                Media tempObj = new TVshow("tvShow", title, releaseYear, genre, rating, poster, tempMap);
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

        Collections.sort(temp, (p1, p2) -> p1.getName().compareTo(p2.getName()));

        return temp;
    }

    // returns a list of all unique genres
    private List<String> instantiateGenre() {
        List<String> temp = new ArrayList<>();

        for(Media m : mix) {
            String tempString = m.getGenre().replace(" ", "").toLowerCase();
            String[] genreArray = tempString.split(",");
            for(String genre : genreArray) {
                if(!(temp.contains(genre))) {
                    temp.add(genre);
                }
            }
        }
        return temp;
        // Wrong code check unit test
        /*for(Media m : mix) {
            String[] genreArray = m.getGenre().split(", ");
            for(String genre : genreArray) {
                if(!(temp.contains(genre))) {
                    temp.add(genre.toLowerCase());
                }
            }
        }*/

    }

}
