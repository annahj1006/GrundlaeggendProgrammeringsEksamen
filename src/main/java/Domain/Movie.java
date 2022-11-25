package Domain;

import Domain.Media;

public class Movie {
    protected String title;
    protected String releaseYear;
    protected String genre;
    protected String rating;
    protected String imagePath;
    Movie(String title, String releaseYear, String genre, String rating) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
    }

    String getName() {
        return title;
    }
    String getReleaseYear() {
        return releaseYear;
    }
    String getGenre() {
        return genre;
    }
    String getRating() {
        return rating;
    }
    String getImagePath() {
        return imagePath;
    }
    void setImagePath(String path) {
        imagePath = path;
    }

    public String toString() {
        return (getName() + " - " + getReleaseYear() + " - " + getGenre() + " - " + getRating() + " - " + getImagePath());
    }



}
