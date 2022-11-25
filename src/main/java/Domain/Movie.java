package Domain;

import Domain.Media;
import java.util.ArrayList;
import java.util.List;
public class Movie {
    protected String title;
    protected int releaseYear;
    protected List<String> genre;
    protected double rating;
    Movie(String title, int releaseYear, ArrayList<String> genre, double rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }




}
