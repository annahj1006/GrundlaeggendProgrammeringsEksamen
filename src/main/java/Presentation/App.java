package Presentation;

import Domain.Media;
import Domain.MediaController;
import Domain.Movie;
import Domain.TVshow;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        Media m = new Media("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater");
        m.instanziateMedia();

        Media t = new Media("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider");
        t.instanziateMedia();

        for(MediaController media : t.mix) {
            System.out.println(media.toString());
        }

    }

}
