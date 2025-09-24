package se.jensen.johanna.library;

import java.util.List;

public class Member {
    private String username;
    private String password;
    private List<Book> borrowedBooks;



    public Member(String username, String password) {
        this.username = username;
        this.password = password;
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

    public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }

  

  
}
