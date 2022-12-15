package Test;

import Domain.Operations;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import java.io.FileNotFoundException;
import java.util.Collections;
import static org.junit.Assert.*;

public class OperationsTest {
    private Operations o;
    @Before
    public void setup() throws FileNotFoundException {
         o = new Operations();
    }
    @After
    public void teardown() {
        o = null;
    }

   // Checking if Operations.getMix contains all the media from the txt files (100 films and 100 series)
    @Test
    public void getMix_CheckIfAllMediasAreReturned()  {
        assertEquals(200, o.getMix().size());
    }

    // Checking if all movies are returned by searching 'movie'
    @Test
    public void search_CheckIfAllMoviesAreReturned() {
        assertEquals(100,o.search("movie").size());
    }

    // Checking if all TVshows are returned by searching 'series'
    @Test
    public void search_CheckIfAllTVshowsAreReturned() {
        assertEquals(100,o.search("series").size());
    }

    // Checking if all the genres are saved in a list
    @Test
    public void CheckGenreList() {
        List<String> temp = o.getGenre();
        Collections.sort(temp);
        assertEquals(Arrays.asList("action", "adventure", "animation", "biography", "comedy", "crime", "drama", "family", "fantasy",
                "film-Noir", "history", "horror", "music", "musical", "mystery", "romance", "sci-fi", "sport",
                "thriller", "war", "western"), temp);
    }

    // Checking if the search by keyword (searchByTitle-method) works, with a small result
    @Test
    public void searchByTitle_SmallTest()  {
        assertEquals(2, o.searchByTitle("1").size());
    }

    // Checking if the search by keyword (searchByTitle-method) works, with a big result
    @Test
    public void searchByTitle_BigTest()  {
        assertEquals(149, o.searchByTitle("e").size());
    }

    // Checking if the search by keyword (searchByTitle-method) returns an empty list if it is
    // given a string which no media title contains
    @Test
    public void searchForEmptyList() {
        assertEquals(Collections.emptyList(), o.searchByTitle("9"));
    }
}