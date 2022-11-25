package Presentation;

import Domain.Media;
import Domain.Movie;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        Media m = new Media("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakator");
        //Media t = new Media("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider");
        m.instanziateMedia();
        //t.instanziateMedia();

        for(Movie movie : m.movies) {
            System.out.println(movie.toString());
        }


        /*
        for(TVshow tvshow : t.tvShow) {
            System.out.println(tvshow.toString());
        }
        */

    }

}
