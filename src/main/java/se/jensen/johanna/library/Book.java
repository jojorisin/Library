package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class Book {
    //private Author author;
    private Author author;
    private String title;
    private String genre;
    private String isbn;
    private Loan loanStatus;
    private boolean isLoaned = false;
    private List<Book> allBooks = new ArrayList<>();

    public Book() {
    }

    ;

    public Book(String title, Author author, String isbn, String genre) {
        this.title = title;
        this.genre = genre;
        this.isbn = isbn;
        this.author = author;
        this.loanStatus = new Loan(); //loan måste ha en default som är available.


    }

    @Override
    public String toString() {
        return "Title: " + title +
                ", Genre: " + genre +
                ", ISBN: " + isbn;
    }

    public Author getAuthor() {
        return author;
    }

    public String getTitle() {
        return title;
    }

    public String getGenre() {
        return genre;
    }

    public String getIsbn() {
        return isbn;
    }

    public Loan getLoanStatus() {
        return loanStatus;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public void setLoan(Loan loanStatus) {
        this.loanStatus = loanStatus;
    }

    public void addNewBook(Book book) {

        allBooks.add(book);
    }

    public void getAllBooks() {
        for (Book book : allBooks) {
            System.out.println(book + " \n");
        }
    }

}
