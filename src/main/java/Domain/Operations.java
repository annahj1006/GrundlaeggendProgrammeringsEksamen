package Domain;

import java.util.List;
import java.util.ArrayList;

public class Operations extends Instantiate {
    private List<String> genres;
    public Operations(String dataPath, String imagePath) {
        super(dataPath, imagePath);
        genres = instantiateGenre();
    }


    public List<Media> search(String word) {
        List<Media> result = new ArrayList<>();
        String searchWord = word.trim().toLowerCase();

        if(searchWord.equals("movie") || searchWord.equals("film")) {
            return getMovies();
        } else if (searchWord.equals("series") || searchWord.equals("serier")) {
            return getTvShow();
        } else if(genres.contains(searchWord)) {
            return result = searchByGenre(searchWord);
        } else {
            for (Media media : mix) {
                if (searchWord.contains(media.getName().toLowerCase())) {
                    return result = searchByTitle(searchWord);
                }
            }
        }
        return null;
    }

    private List<Media> searchByGenre(String keyword) {
        List<Media> temp = new ArrayList<>();
        for(Media media : mix) {
            if(media.getGenre().toLowerCase().contains(keyword)) {
                temp.add(media);
            }
        }
        return temp;
    }

    private List<Media> searchByTitle(String keyword) {
        List<Media> temp = new ArrayList<>();
        for(Media media : mix) {
            if(media.getName().toLowerCase().contains(keyword)) {
                temp.add(media);
            }
        }
        return temp;
    }

    public List<Media> getMovies() {
        return movies;
    }
    public List<Media> getTvShow() {
        return tvShow;
    }
}
