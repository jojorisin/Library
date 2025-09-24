package se.jensen.johanna.library;

import java.time.LocalDateTime;
import java.util.List;

public class Loan {
    private LocalDateTime loanDate;
    private User borrower;
    private List<Book> borrowedBooks;

    public Loan() {

        this.loanDate = LocalDateTime.now();
    }

    public boolean isBorrowed(Book book) {
        return borrowedBooks.contains(book);
    }

    //takes loan with interest and serious debt
    public void takeALoan(Book book, User user) {
        if (!book.getIsLoaned(book)) {
            borrowedBooks.add(book);
            borrower.addBorrowedBooks(book);

        }
    }
    //borrowedBooks.add(book);
        /*if (book != null && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.setLoaned(true);
        }


    }*/

    //shows all bororoorowed books
    public List<Book> getBorrowedBooks() {
        return new ArrayList<>(borrowedBooks);
    }

    //shows bororororower
    public User getBorrower() {
        return borrower;
    }

    //time remaining till doom
    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    //change boolean value to false (putting it back)
    public void returnBook(Book book) {
        if (borrowedBooks.remove(book)) {
            book.setLoaned(false);
        }

    }

/*
    //checking status
    public boolean isLoaned() {
        return isLoaned;
    }
*/

    //check for loan is true or false
    // public void loanStatus(Book book) {
    //   return loanStatus;
}//

    public void addBookToLoan(String bookTitle) {

    }


}
