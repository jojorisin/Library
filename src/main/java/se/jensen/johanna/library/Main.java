package se.jensen.johanna.library;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        AddToDatabase addToDatabase = new AddToDatabase(bookRepository, userRepository, authorRepository);
        addToDatabase.addAuthorAndBooksFromFile();
        addToDatabase.addUserFromFile();
        Library library = new Library(bookRepository, authorRepository);
        LoginService loginService = new LoginService(userRepository, sc);
        User user = loginService.logInUser();
        HomePage homePage = new HomePage(user, library, sc);
        homePage.displayMenu();

    }
}
