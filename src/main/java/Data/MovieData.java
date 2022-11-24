package Data;

import java.util.*;
import java.io.File;

public class MovieData {
    public static void main(String[] args) throws Exception {
        File file = new File("././resources/Data/film.txt");
        Scanner s = new Scanner(file);
        System.out.println(s.nextLine());
    }




}
