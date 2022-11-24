package Data;

import java.util.*;
import java.io.File;


public class MovieData {

    public static void main(String[] args) throws Exception {
        Map<String, ArrayList<String>> film = new HashMap<>();
        //HashMap serie;
        File file = new File("src/main/resources/Data/film.txt");
        Scanner s = new Scanner(file);

        //serie = new HashMap<String, ArrayList<String>>();
        while (s.hasNextLine()) {
            String dataEntry = s.nextLine();
            String mediaName = dataEntry.substring(0, dataEntry.indexOf("; "));
            String mediaInfo = dataEntry.substring(dataEntry.indexOf("; ") + 1);
            String[] line = mediaInfo.split("; ");

            ArrayList<String> arr = new ArrayList<>();
            for(String ele : line) {
                arr.add(ele);
            }

            film.put(mediaName, arr);


            /*
                Print key value pair
            film.entrySet().forEach(entry->{
                System.out.println(entry.getKey() + " = " + entry.getValue());
            });
            */
        }

        // Get a single value from the arraylist
        //System.out.println(film.get("Mr Smith Goes To Washington").get(2));
    }
}
