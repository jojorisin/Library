package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class BookRepository {
    private final List<Book> books;

    public BookRepository() {
        this.books = new ArrayList<>();
    }

    public void addBook(Book book) {
        books.add(book);

    }

    public void removeBook(Book book) {
        books.remove(book);
    }

    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book + "\n");
        }
    }

    public Book getBookByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Cant Find Book With That Title");
        return null;


    }

    public List<Book> getAllBooks() {
        return books;
    }
}
