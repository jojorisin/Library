package se.jensen.johanna.library;

public class Main {
    public static void main(String[] args) {

        BookRepository bookRepository = new BookRepository();
        UserRepository userRepository = new UserRepository();
        AuthorRepository authorRepository = new AuthorRepository();
        AddToDatabase addToDatabase = new AddToDatabase(bookRepository, userRepository, authorRepository);
        addToDatabase.addAuthorAndBooksFromFile();
        Library library = new Library(bookRepository, authorRepository);
        User user = new User("Per", "nissepisse");
        userRepository.addUser(user);
        LoginService loginService = new LoginService(userRepository);
        loginService.logInUser();
        HomePage homePage = new HomePage(user, library);
        homePage.displayMenu();

    }
}
