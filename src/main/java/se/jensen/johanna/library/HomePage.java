package se.jensen.johanna.library;

import java.util.Scanner;

public class HomePage {
    //private Database db;
    Scanner scanner = new Scanner(System.in);
    //Book myBooks = new Book();
    //Loan myBorrowedBooks = new Loan();
    private User currentUser;
    private Loan loan;
    private Library library;

    public HomePage(User currentUser, Library library) {
        this.currentUser = currentUser;
        //this.db = db;
        //this.loan = new Loan(currentUser);
        this.library = library;
    }

    public void displayMenu() {
        boolean displayMenu = true;

        while (displayMenu) {
            System.out.println("Välj ett alternativ: " + "\n"
                    + " 1. Se alla böcker som finns " + "\n"
                    + " 2. Låna en bok " + "\n"
                    + " 3. Lista alla lån " + "\n"
                    + "4. Lämna bibioteket.");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1":
                    library.showLibraryBooks();
                    break;

                case "2":
                    library.showLibraryBooks();
                    System.out.println("Skriv titeln på boken du vill låna");
                    Book bookToLoan = library.getBookByTitle(scanner.nextLine());
                    //String bookOfChoice = scanner.nextLine();
                    //här ska vi skapa loanService som sköter databas för lån
                    // Book bookToLoan = library.getBookByTitle(bookOfChoice);
                    this.loan = new Loan(bookToLoan, currentUser);
                    currentUser.addBookToLoan(loan);
                    System.out.println("Du har lånat " + currentUser.getBorrowedBooks());


                case "3":
                    //myBorrowedBooks.getBorrowedBooks();


                case "4":
                    displayMenu = false;

            }
            scanner.close();
        }

    }


}
