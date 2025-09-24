package se.jensen.johanna.library;

public class Login {
    private Database db;
    boolean loggedIn = false;
    private User user;


    public Login(Database db) {
        this.db = db;


    }


    public User logIn(String userName, String passWord, Database db) {
        User user = db.getUserByUserName(userName);
        if (user.getUsername().equals(userName) && user.getPassword().equals(passWord)) {
            user.setLoggedIn();
            return user;

        }
        return null;


    }

}
