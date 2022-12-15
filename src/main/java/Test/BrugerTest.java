package Test;

import Domain.Bruger;
import Domain.Media;
import Domain.Movie;
import Domain.Operations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;


import static org.junit.Assert.*;

public class BrugerTest {
    private Operations o;
    private Bruger nyBruger;

    @Before
    public void setup() throws IOException {
        o = new Operations();
        nyBruger = new Bruger("Oliver");
    }
    @After
    public void teardown() {
        o = null;
        nyBruger = null;
    }

    // Checking if the users name is returned
    @Test
    public void returnName() {
        assertEquals("Oliver", nyBruger.getName());
    }

    // Checking if the users favorite list is correct after adding elements.
    @Test
    public void addToFavoriteListe() {
        Media toAdd0 = new Movie("movie", "12 Angry Men", "1957", "Crime, Drama", "8,9", "src/main/resources/Data/filmplakater/12 Angry Men.JPG");
        Media toAdd1 = new Movie("movie", "2001 A Space Odyssey", "1968", "Adventure, Sci-fi", "8,3", "src/main/resources/Data/filmplakater/2001 A Space Odyssey.JPG");
        nyBruger.addMedia(toAdd0);
        nyBruger.addMedia(toAdd1);
        assertEquals(Arrays.asList(toAdd0, toAdd1), nyBruger.getMyList());
    }

    // Checkinf if the users favorite list is correct after removing one element
    @Test
    public void removeFromFavoriteLise() {
        Media toAdd0 = new Movie("movie", "12 Angry Men", "1957", "Crime, Drama", "8,9", "src/main/resources/Data/filmplakater/12 Angry Men.JPG");
        Media toAdd1 = new Movie("movie", "2001 A Space Odyssey", "1968", "Adventure, Sci-fi", "8,3", "src/main/resources/Data/filmplakater/2001 A Space Odyssey.JPG");
        nyBruger.addMedia(toAdd0);
        nyBruger.addMedia(toAdd1);
        nyBruger.removeMedia(toAdd0);

        assertEquals(Arrays.asList(toAdd1), nyBruger.getMyList());
    }

    @Test
    public void mediaExistsInFavoriteList() {
        Media toAdd0 = new Movie("movie", "12 Angry Men", "1957", "Crime, Drama", "8,9", "src/main/resources/Data/filmplakater/12 Angry Men.JPG");
        Media toAdd1 = new Movie("movie", "2001 A Space Odyssey", "1968", "Adventure, Sci-fi", "8,3", "src/main/resources/Data/filmplakater/2001 A Space Odyssey.JPG");
        nyBruger.addMedia(toAdd0);
        nyBruger.addMedia(toAdd1);
        assertEquals(true, nyBruger.mediaExsists(toAdd0));
    }
}