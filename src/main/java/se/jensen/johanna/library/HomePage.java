package se.jensen.johanna.library;

import java.util.Scanner;

public class HomePage {
    private Database db;
    Scanner scanner = new Scanner(System.in);
    Book myBooks = new Book();
    //Loan myBorrowedBooks = new Loan();
    private User currentUser;
    private Loan loan;

    public HomePage(User currentUser, Database db) {
        this.currentUser = currentUser;
        this.db = db;
        this.loan = new Loan(currentUser);
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
                    db.getBooks();
                    break;

                case "2":
                    db.getBooks();
                    System.out.println("Skriv titeln på boken du vill låna");
                    String bookToBorrow = scanner.nextLine();
                    Book getLoan = db.getBooksByTitle(bookToBorrow);
                    loan.takeALoan(getLoan, currentUser);
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
