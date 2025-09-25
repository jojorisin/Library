package se.jensen.johanna.library;

import java.time.LocalDateTime;

public class Loan {
    private LocalDateTime loanDate;
    private LocalDateTime returnDate;
    private User user;
    private Book loanedBook;

    public Loan() {

        this.loanDate = LocalDateTime.now();
        this.returnDate = loanDate.plusMonths(1);
    }

    @Override
    public String toString() {
        return "\n" + loanedBook +
                "\n Date Of Loan: " + loanDate +
                "\n" + " Return Before: " + returnDate;
    }

    public LocalDateTime dateOfLoan() {
        return loanDate;
    }

    public Book getLoanedBook() {
        return loanedBook;
    }

    public User getUser() {
        return user;
    }

    public LocalDateTime getReturnDate() {
        return returnDate;

    }


}




    //check for loan is true or false
    // public void loanStatus(Book book) {
    //   return loanStatus;
}//

    public void addBookToLoan(String bookTitle) {

    }


}
