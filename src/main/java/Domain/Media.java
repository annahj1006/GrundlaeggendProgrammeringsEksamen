package Domain;

public class Media {
    protected String id;
    protected String title;
    protected String releaseYear;
    protected String genre;
    protected String rating;
    protected String poster;
    private String addedState;
    public Media(String id, String title, String releaseYear, String genre, String rating, String poster) {
        this.id = id;
        this.title = title;
        this.releaseYear = releaseYear;
        this.genre = genre;
        this.rating = rating;
        this.poster = poster;
        addedState = "+";
    }
    public String getId() {
        return id;
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
    public String getRating() { return rating; }
    public String getPoster() { return poster; }
    public void setAddedState(String newState) {
        addedState = newState;
    }
    public String getAddedState() {
        return addedState;
    }
    public String toString() {
        return (getName() + "; " + getReleaseYear() + "; " + getGenre() + "; ");
    }
}
