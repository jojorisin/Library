package se.jensen.johanna.library;

import java.util.Scanner;

public class HomePage {
    Scanner sc;
    private final User currentUser;
    private final Library library;
    private final LoanService loanService;

    public HomePage(User currentUser, Library library, Scanner sc) {
        this.currentUser = currentUser;
        this.library = library;
        this.loanService = new LoanService();
        this.sc = sc;
    }

    public void displayMenu() {
        boolean displayMenu = true;

        while (displayMenu) {
            System.out.println("\n" + "Choose An Option: " + "\n"
                    + " 1. Show All Books In Library" + "\n"
                    + "2. Search Books By Author" + "\n"
                    + " 3. Borrow A Book " + "\n"
                    + "4. Return A Book" + "\n"
                    + " 5. See Your Borrowed Books " + "\n"
                    + "6. Log out.");
            String choice = sc.nextLine();

            switch (choice) {
                case "1":
                    library.showLibraryBooks();
                    displayMenu();
                    break;

                case "2":
                    System.out.println("Please enter name of writer");
                    String nameToSearch = sc.nextLine();
                    try {
                        Author authorToSearch = library.getAuthorByName(nameToSearch);
                        authorToSearch.printBooksByAuthor();
                        System.out.println("Do You Want To Make A Loan?");
                        if (sc.nextLine().equalsIgnoreCase("yes")) {
                            handleLoans();
                        }

                    } catch (NullPointerException e) {
                        e.getMessage();
                    }
                    displayMenu();
                    break;


                case "3":
                    library.showLibraryBooks();
                    handleLoans();
                    break;


                case "4":
                    System.out.println("Active Loans: ");
                    currentUser.showLoanedBooks();
                    handleReturnBook();
                    break;

                case "5":
                    currentUser.showLoanedBooks();
                    System.out.println("Do You Want To Return A Book?");
                    if (sc.nextLine().equalsIgnoreCase("yes")) {
                        handleReturnBook();
                        currentUser.showLoanedBooks();

                    }
                    break;

                case "6":
                    System.out.println("Thank you For Visiting Library.");
                    return;

            }

        }

    }

    private void handleReturnBook() {
        System.out.println(" Which book do you wish to return?");
        String loanToReturn = sc.nextLine();
        Loan loan = currentUser.getLoan(loanToReturn);
        try {
            if (loanService.returnLoan(loan)) {
                System.out.println("Return Was Successful");
            }

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

        }


    }

    private void handleLoans() {
        System.out.println("Enter Title Of Book You Want To Borrow:");
        String bookToLoan = sc.nextLine();
        Book book = library.getBookByTitle(bookToLoan);
        try {
            loanService.takeALoan(currentUser, book);
            System.out.println("You Have Borrowed: " + bookToLoan);

        } catch (IllegalStateException e) {
            System.out.println(e.getMessage());
        }

    }

}
