package Domain;

import Data.MediaData;

import java.util.List;
import java.util.ArrayList;
import java.util.Collections;




public class Instantiate {

    // Ligegydlige?
    //public MediaData movieData;
    //public MediaData serieData;
    public List<Media> movies;
    public List<Media> tvShow;
    public List<Media> mix;



    public Instantiate() {

        movies = new ArrayList<>();
        tvShow = new ArrayList<>();

        // Ligegyldige pt 2?
        //movieData = new MediaData("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater");
        //serieData = new MediaData("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider");


        instantiateMedia(new MediaData("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater"));
        instantiateMedia(new MediaData("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider"));

        mix = getCombinedMediaList();
    }

    private void instantiateMedia(MediaData data) {

        List<String> posters = data.loadImageData();
        List<String> media = data.loadData();
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
                Media temp = new Movie("movie", title, releaseYear, genre, rating, poster);
                movies.add(temp);
            } else if(elements.length == 5) {
                Media temp = new TVshow("tvShow", title, releaseYear, genre, rating, poster, elements[4].substring(1, elements[4].length()));
                tvShow.add(temp);
            }
            i++;
        }
    }

    private List<Media> getCombinedMediaList() {
        List<Media> temp = new ArrayList<>();
        for(Media movie : movies) {
            temp.add(movie);
        }
        for(Media tvShow : tvShow) {
            temp.add(tvShow);
        }
        return temp;
    }

    protected List<String> instantiateGenre() {
        List<String> temp = new ArrayList<>();

        for(Media m : getCombinedMediaList()) {
            String[] s = m.getGenre().split(", ");
            for(String sx : s) {
                if(!(temp.contains(sx))) {
                    temp.add(sx.toLowerCase());
                }
            }
        }
        return temp;
    }

}
