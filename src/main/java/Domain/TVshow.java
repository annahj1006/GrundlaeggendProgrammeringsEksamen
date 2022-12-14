package Domain;

import java.util.Map;

public class TVshow extends Media{
    private Map<String, String> episodes;

    public TVshow(String id, String title, String releaseYear, String genre, String rating, String poster, Map<String, String> seriesEpisodes) {
        super(id, title, releaseYear, genre, rating, poster);
        episodes = seriesEpisodes;
    }
    // Returns the series and episodes
    public String getSeriesEpisodes() {
        String temp = "";
        for (Map.Entry<String, String> pair : episodes.entrySet()) {
            temp += pair.getKey() + "-" + pair.getValue() + ";";
        }
        return temp;
    }

    public String toString() {
       String temp = "";
        for (Map.Entry<String, String> pair : episodes.entrySet()) {
           temp += " " + pair.getKey() + "-" + pair.getValue() + ";";
        }
        return super.toString() + getRating() + ";" + temp;

    }
}
