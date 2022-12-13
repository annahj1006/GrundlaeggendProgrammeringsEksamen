package Domain;
import java.util.List;
import java.util.ArrayList;
public class NoResultsFoundException extends RuntimeException {
    protected List<Media> emptyList;
    public NoResultsFoundException(List<Media> emptyList) {
        super("No results found");
        this.emptyList = emptyList;
    }

    public List<Media> getEmptyList() {
        return emptyList;
    }
}
