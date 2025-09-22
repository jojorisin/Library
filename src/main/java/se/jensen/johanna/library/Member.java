package se.jensen.johanna.library;

import java.util.List;

public class Member {
    private String username;
    private String password;
    private List borrowedBooks;
    private int loanDate;

    public Member(String username, String password, List borrowedBooks, int loanDate) {
        this.username = username;
        this.password = password;
        this.borrowedBooks = borrowedBooks;
        this.loanDate = loanDate;
    }

    public List getBorrowedBooks() {
        return borrowedBooks;
    }

    public int getLoanDate() {
        return loanDate;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
