package Presentation;

import Domain.Media;
import Domain.Movie;
import Domain.TVshow;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.util.Collections;

public class App {
    public static void main(String[] args) throws Exception {

        Media m = new Media("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater");
        m.instanziateMedia();


        for(Movie movie : m.movies) {
            System.out.println(movie.toString());
        }

        System.out.println();
        System.out.println("=====================");
        System.out.println();

        Media t = new Media("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider");

        t.instanziateMedia();
        for(TVshow tvshow : t.tvShow) {
            System.out.println(tvshow.toString());
        }


    }

}
