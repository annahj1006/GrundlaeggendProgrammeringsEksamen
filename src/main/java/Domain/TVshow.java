package Domain;

import Domain.Media;

public class TVshow extends Media{
    private String episodes;

    public TVshow(String id, String title, String releaseYear, String genre, String rating, String poster, String episode) {
        super(id, title, releaseYear, genre, rating, poster);
        this.episodes = episode;
    }

    public String getEpisodes() {
        return episodes;
    }

    public String toString() {
        return super.toString() + getEpisodes() + "; " + getRating() + ";";
    }
}
