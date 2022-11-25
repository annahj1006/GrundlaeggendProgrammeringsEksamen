package Data;

import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class MovieData {

    private String filePath;

    public MovieData(String filePath) {
        this.filePath = filePath;
    }

    public List<String> loadData() {
        List<String> media = new ArrayList<>();

        try {
            Scanner scan = new Scanner(new File(filePath));

            while (scan.hasNextLine()) {
                media.add(scan.nextLine());
            }
            scan.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file found");
        }

        return media;
    }



    /*public static void main(String[] args)  {
        Map<String, ArrayList<String>> film = new HashMap<>();
        //HashMap serie;
        //File file = new File("src/main/resources/Data/film.txt");
        //Scanner s = new Scanner(file);

        //serie = new HashMap<String, ArrayList<String>>();

        //String dataEntry = s.nextLine();
        //String mediaName = dataEntry.substring(0, dataEntry.indexOf("; "));
        //String mediaInfo = dataEntry.substring(dataEntry.indexOf("; ") + 1);
        //String[] line = mediaInfo.split("; ");

        //ArrayList<String> arr = new ArrayList<>();


        //media.put(mediaName, arr);


            /*
                Print key value pair
            film.entrySet().forEach(entry->{
                System.out.println(entry.getKey() + " = " + entry.getValue());
            });

             */

        // Get a single value from the arraylist
        //System.out.println(film.get("Mr Smith Goes To Washington").get(2));
}
