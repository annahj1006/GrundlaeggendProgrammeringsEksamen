package Domain;

// This class is a singleton and is used to store the user that is currently "logged in"
public class CurrentUserSingleton {

    private static final CurrentUserSingleton instance = new CurrentUserSingleton();

    private Bruger user;

    private CurrentUserSingleton(){}

    public static CurrentUserSingleton getInstance() {
        return instance;
    }

    public void setUser(Bruger userName) {
        this.user = userName;
    }

    public Bruger getUser() {
        return user;
    }
}

