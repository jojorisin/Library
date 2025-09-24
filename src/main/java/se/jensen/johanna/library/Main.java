package se.jensen.johanna.library;

public class Main {
    public static void main(String[] args) {

        Author a1 = new Author("Astrid", "Lindgren");
        Book b1 = new Book("Pippi långstrump", a1, "2345", "Barnbok");
        Author a2 = new Author("Harry", "Beam");
        Book b2 = new Book("Bim Am", a2, "57483", "Science Fiction");
        a2.addBookByAuthor(b2);
        a1.addBookByAuthor(b1);
        Author a3 = new Author("Leo", "Äppel");
        Book b3 = new Book("Biography of George", a3, "65748", "Skräck");
        a3.addBookByAuthor(b3);
        Author a4 = new Author("Sam", "Charles");
        Book b4 = new Book("Charlestown", a4, "65467", "Science Fiction");
        a4.addBookByAuthor(b4);
        Author a5 = new Author("Bam", "Margera");
        Book b5 = new Book("Sam Bam", a5, "67549", "Biografi");
        a5.addBookByAuthor(b5);
        
        Book book = new Book();

        book.addNewBook(b1);
        book.addNewBook(b2);
        book.addNewBook(b3);
        book.addNewBook(b4);
        book.addNewBook(b5);
        book.getAllBooks();
    }
}
