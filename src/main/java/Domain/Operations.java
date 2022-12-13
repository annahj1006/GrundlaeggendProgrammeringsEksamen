package Domain;


import java.io.FileNotFoundException;
import java.util.List;
import java.util.ArrayList;

public class Operations extends Instantiate {

    CurrentUserSingleton data;
    Bruger currentUser;

    //Constructor allows access to the current user
    public Operations() throws FileNotFoundException {
        data = CurrentUserSingleton.getInstance();
        currentUser = data.getUser();
    }

    // Our search function for the searchbar on the homepage (utilizes the searchByTitle function)
    public List<Media> search(String word) {
        String searchWord = word.trim().toLowerCase();

        if (searchWord.equals("movie") || searchWord.equals("film")) {
            return getMovies();
        } else if (searchWord.equals("series") || searchWord.equals("serier")) {
            return getTvShow();
        } else if (genreList.contains(searchWord)) {
            return searchByGenre(searchWord);
        } else {
            if(searchByTitle(word).size() == 0) {
                throw new NoResultsFoundException();
            } else {
                return searchByTitle(word);
            }
        }
    }


    // Allows us to filter movies and series by genre
    public List<Media> searchByGenre(String keyword) {
        List<Media> temp = new ArrayList<>();
        for (Media media : mix) {
            if (media.getGenre().toLowerCase().contains(keyword)) {
                temp.add(media);
            }
        }
        return temp;
    }

    // Allows us to search by a keyword
    public List<Media> searchByTitle(String keyword) {
        List<Media> temp = new ArrayList<>();
        for (Media media : mix) {
            if (media.getName().toLowerCase().contains(keyword)) {
                temp.add(media);
            }
        }
        return temp;
    }

    // Returns different list so they can be accessed by different parts of the program.
    public List<Media> getMyList() { return currentUser.getMyList(); }
    public List<Media> getMovies() {
        return movies;
    }
    public List<Media> getTvShow() {
        return tvShow;
    }
    public List<Media> getMix() {return mix;}
}
