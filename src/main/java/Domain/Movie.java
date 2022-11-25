package Domain;

import Domain.Media;

public class Movie {
    protected String title;
    protected String releaseYear;
    protected String genre;
    protected String rating;
    protected String poster;
    Movie(String title, String releaseYear, String genre, String rating, String poster) {
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
        this.poster = poster;
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
    public String getPoster() {
        return poster;
    }

    public String toString() {
        return (getName() + " - " + getReleaseYear() + " - " + getGenre() + " - " + getRating() + " - " + getPoster());
    }



}
