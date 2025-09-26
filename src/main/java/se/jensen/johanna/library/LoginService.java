package se.jensen.johanna.library;

import java.util.Scanner;

public class LoginService {
    private final Scanner sc;
    private final Login login;


    public LoginService(UserRepository userRepo, Scanner sc) {
        this.login = new Login(userRepo);
        this.sc = sc;

    }

    public User logInUser() {

        while (true) {
            System.out.println("Enter UserName: ");
            String userName = sc.nextLine();
            System.out.println("Enter Password: ");
            String passWord = sc.nextLine();
            User loggedInUser = login.logIn(userName, passWord);

            if (loggedInUser != null) {
                System.out.println("Login Was Successful \n");
                return loggedInUser;
            } else {
                System.out.println("Wrong Username Or Password");
            }

        }

    }


}
