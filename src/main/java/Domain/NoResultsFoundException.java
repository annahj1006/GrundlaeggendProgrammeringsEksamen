package Domain;

public class NoResultsFoundException extends RuntimeException {

    public NoResultsFoundException() {
        super("Ingen resultater fundet.");
    }
}
