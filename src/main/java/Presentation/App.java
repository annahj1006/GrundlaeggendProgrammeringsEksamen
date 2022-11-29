package Presentation;

import Domain.MediaMaking;
import Domain.Media;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        MediaMaking m = new MediaMaking("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater");
        m.instanziateMedia();

        MediaMaking t = new MediaMaking("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider");
        t.instanziateMedia();

        List<Media> mix = new ArrayList<>();
        for(Media media : m.movies) {
            mix.add(media);
        }
        for(Media media : t.tvShow) {
            mix.add(media);
        }


    }

}
