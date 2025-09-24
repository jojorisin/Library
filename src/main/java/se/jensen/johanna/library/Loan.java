package se.jensen.johanna.library;

import java.time.LocalDateTime;

public class Loan {
    private LocalDateTime loanDate;
    private User user;
    private Book loanedBook;

    public Loan() {

        this.loanDate = LocalDateTime.now();
    }

    @Override
    public String toString() {
        return "" + loanedBook +
                ", Datum: " + loanDate;
    }

    public LocalDateTime dateOfLoan() {
        return loanDate;
    }

    /*public boolean isBorrowed(Book book) {
        return borrowedBooks.contains(book);
    }*/

    /*public void takeALoan(Book book, User borrower) {
        if (!book.getIsLoaned(book)) {
            borrowedBooks.add(book);
            borrower.addBorrowedBooks(book);

        }
    }*/
    //borrowedBooks.add(book);
        /*if (book != null && !borrowedBooks.contains(book)) {
            borrowedBooks.add(book);
            book.setLoaned(true);
        }


    }*/

    /*public List<Book> getBorrowedBooks() {
        return borrowedBooks;
    }*/

    //Detta ska vara i admin. User har tillgång till sina lån och admin har tillgång til alla users lån
   /* public User getBorrower() {
        return borrower;
    }*/

    //time remaining till doom
    public LocalDateTime getLoanDate() {
        return loanDate;
    }

    //change boolean value to false (putting it back)
    public Book getLoanedBook() {
        return loanedBook;

    }


    //check for loan is true or false
    // public void loanStatus(Book book) {
    //   return loanStatus;
}//

    public void addBookToLoan(String bookTitle) {

    }


}
