package Domain;

import java.util.ArrayList;
import java.util.List;

public class Bruger {

    public List<Media> fav;
    public String name;


    public Bruger(String name) {
        this.name = name;
        fav = new ArrayList<>();
    }

    public String getName() {
        return this.name;
    }

    public void addMedia(Media media) {
        fav.add(media);
        System.out.println(media.toString() + " was added to fav.");
    }

    public void removeMedia(Media media) {
        fav.remove(media);
        System.out.println(media.toString() + " was removed to fav.");
    }

    public boolean mediaExsists(Media media) {
        if(fav.contains(media)) {
            return true;
        }
        return false;
    }

}
