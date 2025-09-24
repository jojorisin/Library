package se.jensen.johanna.library;

import java.time.LocalDateTime;
import java.util.List;

public class Loan {
    private LocalDateTime loanDate;
    private List<Book> borrowedBooks;
    private Member borrower;
    //private List<Loan> loanedBooks;

    public Loan() {

        this.loanDate = LocalDateTime.now();
    }

    public void loanStatus(Book book) {

    }

    public void addBookToLoan(String bookTitle) {

    }


}
