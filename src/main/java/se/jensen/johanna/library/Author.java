package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class Author {
    private String firstName;
    private String lastName;
    private List<Book> booksByAuthor;

    public Author(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        booksByAuthor = new ArrayList<>();


    }

    @Override
    public String toString() {
        return firstName + " " + lastName;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<Book> getBooksByAuthor() {
        return booksByAuthor;
    }

    public void printBooksByAuthor() {
        for (Book book : booksByAuthor) {
            System.out.println(book.getTitle());
        }
    }

    public void addBookByAuthor(Book book) {
        booksByAuthor.add(book);
    }
}
