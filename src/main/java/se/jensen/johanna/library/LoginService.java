package se.jensen.johanna.library;

import java.util.Scanner;

public class LoginService {
    //private Database db;
    private UserRepository userRepo;
    private static Scanner sc = new Scanner(System.in);
    private Login login;
    private User user;

    public LoginService(UserRepository userRepo) {
        // this.db = db;
        this.userRepo = userRepo;
        this.login = new Login(userRepo);

    }

    public User logInUser() {

        while (true) {
            System.out.println("Welcome To The Library");
            System.out.println("Enter UserName: ");
            String userName = sc.nextLine();
            System.out.println("Enter Password: ");
            String passWord = sc.nextLine();
            User loggedInUser = login.logIn(userName, passWord);

            if (loggedInUser != null) {
                System.out.println("Login Was Successful \n");
                //HomePage homePage = new HomePage(loggedInUser);
                //homePage.displayMenu();
                return loggedInUser;
                //break;
            } else {
                System.out.println("Fel användarnamn eller lösenord");
            }

        }

    }


}
