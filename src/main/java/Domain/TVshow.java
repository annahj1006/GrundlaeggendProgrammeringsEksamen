package Domain;

public class TVshow {
    protected String title;
    protected String releaseYear;
    protected String genre;
    protected String rating;
    protected String episodes;
    protected String imagePath;
        TVshow(String title, String releaseYear, String genre, String rating, String episodes) {
            this.title = title;
            this.releaseYear = releaseYear;
            this.genre = genre;
            this.rating = rating;
            this.episodes = episodes;
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

        String getEpisodes() {
            return episodes;
        }
        String getImagePath() {
            return imagePath;
        }
        void setImagePath(String path) {
            imagePath = path;
        }
}
