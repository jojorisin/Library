package se.jensen.johanna.library;

public class Main {
    public static void main(String[] args) {
        //Database db = new Database();
        BookRepository bookRepo = new BookRepository();
        UserRepository userRepo = new UserRepository();
        Library library = new Library(bookRepo);


        Author a1 = new Author("Astrid", "Lindgren");
        Book b1 = new Book("Pippi långstrump", a1, "2345", "Barnbok");
        a1.addBookByAuthor(b1);
        bookRepo.addBook(b1);
        Author a2 = new Author("Harry", "Beam");
        Book b2 = new Book("Bim Am", a2, "57483", "Science Fiction");
        a2.addBookByAuthor(b2);
        bookRepo.addBook(b2);
        Author a3 = new Author("Leo", "Äppel");
        Book b3 = new Book("Biography of George", a3, "65748", "Skräck");
        a3.addBookByAuthor(b3);
        bookRepo.addBook(b3);
        Author a4 = new Author("Sam", "Charles");
        Book b4 = new Book("Charlestown", a4, "65467", "Science Fiction");
        a4.addBookByAuthor(b4);
        bookRepo.addBook(b4);
        Author a5 = new Author("Bam", "Margera");
        Book b5 = new Book("Sam Bam", a5, "67549", "Biografi");
        a5.addBookByAuthor(b5);
        bookRepo.addBook(b5);

        User u1 = new User("Johanna", "intellij");
        userRepo.addUser(u1);
        User u2 = new User("Lasse", "hundkoja");
        userRepo.addUser(u2);
        User u3 = new User("Lena", "vattenflaska");
        userRepo.addUser(u3);


        WelcomePage welcomePage = new WelcomePage(userRepo);
        User currentUser = welcomePage.logInUser();
        HomePage homePage = new HomePage(currentUser, library);
        homePage.displayMenu();


        //fixa authorrepository. separera admin från de user kan se


    }
}
