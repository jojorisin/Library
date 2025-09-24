package se.jensen.johanna.library;

public class Login {
    //private Database db;
    private UserRepository userRepo;
    boolean loggedIn = false;
    private User user;


    public Login(UserRepository userRepo) {
        this.userRepo = userRepo;


    }


    public User logIn(String userName, String passWord) {
        User user = userRepo.getUserByUserName(userName);
        if (user.getUsername().equalsIgnoreCase(userName) && user.getPassword().equals(passWord)) {
            user.setLoggedIn();
            return user;

        }
        return null;


    }

}
