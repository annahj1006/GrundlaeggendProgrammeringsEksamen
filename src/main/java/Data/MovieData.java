package Data;

import java.util.*;
import java.io.File;


public class MovieData {

    public static void main(String[] args) throws Exception {
        HashMap film;
        HashMap serie;
        File file = new File("src/main/resources/Data/film.txt");
        Scanner s = new Scanner(file);
        //System.out.println(s.nextLine());
        film = new HashMap<String,ArrayList>();
        serie = new HashMap<String,ArrayList>();
        while(s.hasNextLine()){
            String[] line = s.nextLine().split("; ");
            film.put(line[0], "value");

        }
    }




}
