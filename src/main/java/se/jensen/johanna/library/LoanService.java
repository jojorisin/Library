package se.jensen.johanna.library;

public class LoanService {


    public void takeALoan(User user, Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book does not exist in loans.");
        }
        if (book.getIsLoaned()) {
            throw new IllegalStateException("Book is not available.");
        }
        Loan loan = new Loan(book, user);
        user.addToLoan(loan);
        book.setLoaned(true);

    }


    public boolean returnLoan(Loan loan) {
        if (loan == null) {
            throw new IllegalArgumentException("Loan not found.");
        }
        User user = loan.getUser();
        loan.getLoanedBook().setLoaned(false);
        System.out.println("Returned At: " + loan.getReturnDate());
        user.getBorrowedBooks().remove(loan);
        return true;
    }
}



