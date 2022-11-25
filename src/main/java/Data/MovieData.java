package Data;

import Domain.Movie;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import javax.imageio.ImageIO;


import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;



public class MovieData {

    private String filePath;
    private String imagePath;

    public MovieData(String filePath, String imagePath) {
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

            File dir = new File("src/main/resources/Data/filmplakater");

            for (final File f : dir.listFiles()) {

                posters.add(f.getName());
                //System.out.println("src/main/resources/Data/filmplakater/"+f.getName());

            }


        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return posters;
    }
}
