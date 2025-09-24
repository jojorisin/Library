package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String password;
    private List<Book> borrowedBooks;
    private boolean loggedIn = false;


    public User(String username, String password) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = new ArrayList<>();
    }

    @Override
    public String toString() {
        return "Username: " + username;
    }

    public void addBorrowedBooks(Book book) {
        borrowedBooks.add(book);
    }

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

    public String getUsername() {
        return username;
    }


    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLoggedIn() {
        this.loggedIn = !loggedIn;

    }


}
