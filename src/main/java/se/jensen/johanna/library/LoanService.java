package se.jensen.johanna.library;

public class LoanService {
    private User currentUser;
    private Loan loan;


    public Loan takeALoan(User user, Book book) {
        if (!book.getIsLoaned()) {
            this.loan = new Loan(book, user);
            user.addToLoan(loan);
            book.setLoaned(true);
            return loan;
        }
        System.out.println("Book is not available");
        return null;

    }

    public void returnLoan(Loan loan) {
        User user = loan.getUser();
        loan.getLoanedBook().setLoaned(false);
        user.getBorrowedBooks().remove(loan);
    }
}



