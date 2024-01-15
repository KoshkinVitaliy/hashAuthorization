package user;

public class User {
    public static long userCounter = 0;
    public final String USERNAME;
    public final String PASSWORD;
    public final long ID;
    public final String NAME;

    public User(String USERNAME, String PASSWORD, String NAME) {
        this.USERNAME = USERNAME;
        this.PASSWORD = PASSWORD;
        this.NAME = NAME;
        this.ID = userCounter;

        userCounter++;
    }
}
