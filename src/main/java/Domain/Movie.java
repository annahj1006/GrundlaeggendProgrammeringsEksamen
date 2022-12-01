package Domain;
import Domain.Media;

public class Movie extends Media{
    public Movie(String id, String title, String releaseYear, String genre, String rating, String poster) {
        super(id, title, releaseYear, genre, rating, poster);
    }
}
