package Presentation;


import Domain.Operations;
import Domain.Media;

import java.util.ArrayList;
import java.util.List;


public class App {
    public static void main(String[] args) throws Exception {

        Operations o0 = new Operations("src/main/resources/Data/film.txt", "src/main/resources/Data/filmplakater");
        o0.instantiateMedia();

        Operations o1 = new Operations("src/main/resources/Data/serier.txt", "src/main/resources/Data/serieforsider");
        o1.instantiateMedia();

        List<Media> l1 = o1.getCombinedMediaList();

        for(Media m : l1) {
            System.out.println(m.toString());
        }





    }

}
