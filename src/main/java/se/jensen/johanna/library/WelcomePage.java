package se.jensen.johanna.library;

import java.util.Scanner;

public class WelcomePage {
    //private Database db;
    private UserRepository userRepo;
    private static Scanner sc = new Scanner(System.in);
    private Login login;//hade new Login(userRepo) här men blev fel för den va null, msåte va i konstruktorn för att få samma som från main
    private User user;

    public WelcomePage(UserRepository userRepo) {
        // this.db = db;
        this.userRepo = userRepo;
        this.login = new Login(userRepo);

    }

    public User logInUser() {

        while (true) {
            System.out.println("Välkommen till Biblioteket");
            System.out.println("Vänligen skriv in användarnamn");
            String userName = sc.nextLine();
            System.out.println("Vänligen skriv in lösenord");
            String passWord = sc.nextLine();
            User loggedInUser = login.logIn(userName, passWord);

            if (loggedInUser != null) {
                System.out.println("Du är inloggad");
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
