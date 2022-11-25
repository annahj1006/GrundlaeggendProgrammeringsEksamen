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

    public String getName() {
        return title;
    }
    public String getReleaseYear() {
        return releaseYear;
    }
    public String getGenre() {
        return genre;
    }
    public String getRating() {
        return rating;
    }
    public String getImagePath() {
        return imagePath;
    }
    public void setImagePath(String path) {
        imagePath = path;
    }

    public String toString() {
        return (getName() + " - " + getReleaseYear() + " - " + getGenre() + " - " + getRating() + " - " + getImagePath());
    }



}
