package se.jensen.johanna.library;

import java.util.List;
import java.util.Scanner;

public class HomePage {
    Scanner scanner = new Scanner(System.in);
    private final User currentUser;
    private Loan loan;
    private final Library library;
    private final LoanService loanService;

    public HomePage(User currentUser, Library library) {
        this.currentUser = currentUser;
        //this.db = db;
        //this.loan = new Loan(currentUser);
        this.library = library;
        this.loanService = new LoanService();
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
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    library.showLibraryBooks();
                    break;

                case "2":
                    System.out.println("Please enter name of writer");
                    String writerToSearch = scanner.nextLine();
                    try {
                        Author authorToSearch = library.getAuthorByName(writerToSearch);
                        authorToSearch.printBooksByAuthor();
                    } catch (NullPointerException e) {
                        e.getMessage();
                    }
                    displayMenu();
                    break;


                case "3":
                    library.showLibraryBooks();
                    System.out.println("Enter Title Of Book You Want To Borrow:");
                    Book bookToLoan = library.getBookByTitle(scanner.nextLine());
                    loanService.takeALoan(currentUser, bookToLoan);
                    System.out.println("You Have Borrowed: " + bookToLoan);
                    displayMenu();
                    break;


                case "4":

                    List<Loan> loans = currentUser.getBorrowedBooks();
                    for (Loan userLoans : loans) {
                        System.out.println(userLoans);
                    }
                    System.out.println("Which book do you wish to return?");
                    String loanToReturn = scanner.nextLine();
                    loanService.returnLoan(currentUser.getLoan(loanToReturn));
                    currentUser.showLoanedBooks();
                    displayMenu();
                    break;

                case "5":
                    currentUser.showLoanedBooks();
                    System.out.println("Do You Want To Return A Book?");
                    String answer = scanner.nextLine();
                    if (answer.equals("yes")) {
                        System.out.println("Which book do you wish to return?");
                        String loanToReturn2 = scanner.nextLine();
                        loanService.returnLoan(currentUser.getLoan(loanToReturn2));
                        currentUser.showLoanedBooks();
                        displayMenu();
                        break;

                    } else {
                        break;
                    }

                case "6":
                    displayMenu = false;
                    break;

            }

        }

    }


}
