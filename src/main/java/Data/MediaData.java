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

    public MediaData(String filePath, String imagePath) {
        this.filePath = filePath;
        this.imagePath = imagePath;
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

    public List<String> loadImageData() {
        List<String> posters = new ArrayList<>();
        try {
            File dir = new File(imagePath);

            for (final File f : dir.listFiles()) {
                posters.add(f.getName().substring(0,f.getName().length()-4));
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return posters;
    }

    public void save(List<String> favoritMediaList) {
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
