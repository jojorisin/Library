package se.jensen.johanna.library;

public class Main {
    public static void main(String[] args) {
        Database db = new Database();


        Author a1 = new Author("Astrid", "Lindgren");
        Book b1 = new Book("Pippi långstrump", a1, "2345", "Barnbok");
        a1.addBookByAuthor(b1);
        db.addBook(b1);
        Author a2 = new Author("Harry", "Beam");
        Book b2 = new Book("Bim Am", a2, "57483", "Science Fiction");
        a2.addBookByAuthor(b2);
        db.addBook(b2);
        Author a3 = new Author("Leo", "Äppel");
        Book b3 = new Book("Biography of George", a3, "65748", "Skräck");
        a3.addBookByAuthor(b3);
        db.addBook(b3);
        Author a4 = new Author("Sam", "Charles");
        Book b4 = new Book("Charlestown", a4, "65467", "Science Fiction");
        a4.addBookByAuthor(b4);
        db.addBook(b4);
        Author a5 = new Author("Bam", "Margera");
        Book b5 = new Book("Sam Bam", a5, "67549", "Biografi");
        a5.addBookByAuthor(b5);
        db.addBook(b5);

        User u1 = new User("Johanna", "intellij");
        db.addUser(u1);
        User u2 = new User("Lasse", "hundkoja");
        db.addUser(u2);
        User u3 = new User("Lena", "vattenflaska");
        db.addUser(u3);


        WelcomePage welcomePage = new WelcomePage(db);
        welcomePage.logInMessage();


    }
}
