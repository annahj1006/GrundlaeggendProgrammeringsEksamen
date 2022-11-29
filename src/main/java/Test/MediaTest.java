package Test;

import Domain.Media;
import Domain.MediaMaking;

import java.util.ArrayList;
import java.util.List;

public class MediaTest {
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
