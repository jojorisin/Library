package se.jensen.johanna.library;

import java.util.Scanner;

public class WelcomePage {
    private Database db;
    private static Scanner sc = new Scanner(System.in);
    private Login login = new Login(db);
    private User user;

    public WelcomePage(Database db) {
        this.db = db;

    }

    public void logInMessage() {

        while (true) {
            System.out.println("Välkommen till Biblioteket");
            System.out.println("Vänligen skriv in användarnamn");
            String userName = sc.nextLine();
            System.out.println("Vänligen skriv in lösenord");
            String passWord = sc.nextLine();
            User loggedInUser = login.logIn(userName, passWord, db);

            if (loggedInUser != null) {
                System.out.println("Du är inloggad");
                HomePage homePage = new HomePage(loggedInUser, db);
                homePage.displayMenu();
                break;
            } else {
                System.out.println("Fel användarnamn eller lösenord");
            }

        }

    }


}
