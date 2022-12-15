package Data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class MediaData {

    private String filePath;
    private String imagePath;

    //The constructor takes two arguments, one for the txt document and one for the image files
    public MediaData(String filePath, String imagePath) {
        this.filePath = filePath;
        this.imagePath = imagePath;
    }

    // loadData gets all the information from the txt document and returns it in a lise of strings
    public List<String> loadData() throws FileNotFoundException {
        List<String> media = new ArrayList<>();
        File file = new File(filePath);

       if(file.exists()) {
           Scanner scan = new Scanner(new File(filePath));

           while (scan.hasNextLine()) {
               media.add(scan.nextLine());
           }

           scan.close();
           return media;
       } else {
           throw new FileNotFoundException("No connection to database.");
       }
    }

    // loadImageData gets all the images from the specified imagePath and returns the name of the image in a list
    public List<String> loadImageData() throws FileNotFoundException {
        List<String> posters = new ArrayList<>();

        File file = new File(imagePath);

        if(file.exists()) {
            for (File f : file.listFiles()) {
                posters.add(f.getName().substring(0,f.getName().length()-4));
            }
            return posters;
        } else {
            throw new FileNotFoundException("No connection to database.");
        }
    }

    // The saveMyList function takes a favorite list and a name and save the list in a txt file with the specified name
    public void saveMyList(List<String> favoritMediaList) {
        try {
            File file = new File(filePath);
            PrintWriter printWriter = new PrintWriter(file);
            for(String media : favoritMediaList) {
                printWriter.println(media);
            }
            printWriter.close();
        } catch (FileNotFoundException e) {
            System.out.println("No file. Saving nothing.");
        }
    }
}
