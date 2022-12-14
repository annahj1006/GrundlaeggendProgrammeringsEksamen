package Domain;

import java.util.ArrayList;
import java.util.List;
import Data.MediaData;

public class Bruger {

    private List<Media> fav;
    private String name;
    private MediaData daAccess;

    // The constructor instantiates a variable, a list and a MediaData object
    public Bruger(String name) {
        this.name = name;
        fav = new ArrayList<>();
        daAccess = new MediaData("src/main/resources/Data/" + name, "");

    }

    // getters for the name of the user and their favorite list
    public String getName() {
        return this.name;
    }
    public List<Media> getMyList() { return fav; }

    // Adds a movie/series to the users favorit list
    public void addMedia(Media media) {
        fav.add(media);
        //System.out.println(media.toString() + " was added to fav.");
    }

    // Removes a movie/series from the users favorit list
    public void removeMedia(Media media) {
        fav.remove(media);
        //System.out.println(media.toString() + " was removed to fav.");
    }

    // Checks if a movie/series already is a part of the users favorite list
    public boolean mediaExsists(Media media) {
        for(Media m : fav) {
            if(m.getName().equals(media.getName())) {
                return true;
            }
        }
        return false;
    }

    // Edits the users favorit list from objects to strings and calls the method saveMyList in MediaData
    public void saveMyList() {
        List<String> x = new ArrayList<>();

        for(Media m : fav) {
            x.add(m.toString());
            //System.out.println(m.toString());
        }
        daAccess.saveMyList(x);
    }
}
