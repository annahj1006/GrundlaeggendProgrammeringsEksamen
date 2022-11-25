package Domain;

public class TVshow {
    protected String title;
    protected String releaseYear;
    protected String genre;
    protected String rating;
    protected String episodes;
    protected String poster;
        public TVshow(String title, String releaseYear, String genre, String rating, String poster, String episodes) {
            this.title = title;
            this.releaseYear = releaseYear;
            this.genre = genre;
            this.rating = rating;
            this.poster = poster;
            this.episodes = episodes;

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

        public String getEpisodes() {
            return episodes;
        }
        public String getPoster() {
            return poster;
        }
        public String toString() {
            return (getName() + " - " + getReleaseYear() + " - " + getGenre() + " - " + getRating() + " - " + getEpisodes() + " - " + getPoster());
        }
}
