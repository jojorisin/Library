/*package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class Database {
    private List<User> users;
    private List<Book> books;
    private List<Book> borrowedBooks;
    private BookRepository bookRepository;

    public Database() {
        this.users = new ArrayList<>();
        this.books = new ArrayList<>();
        this.borrowedBooks = new ArrayList<>();
        this.bookRepository = new BookRepository();

    }

    public BookRepository getBooks() {
        return bookRepository;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getUsers() {
        return users;
    }

    public User getUserByUserName(String userName) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(userName)) {
                return user;
            }
            System.out.println("Finns ingen användare med det namnet.");
        }
        return null;
    }

    public void addBook(Book book) {
        books.add(book);
    }

    public void printAllBooks() {
        for (Book book : books) {
            System.out.println(book + "\n");
        }

    }

    public Book getBooksByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equalsIgnoreCase(title)) {
                return book;
            }
        }
        System.out.println("Finns ingen bok med det namnet");
        return null;


    }

    public void addBorrowedBook(Book book) {
        borrowedBooks.add(book);

    }

    public void printAllBorrowedBooks() {
        for (Book book : borrowedBooks) {
            System.out.println(book + "\n");
        }
    }


}
*/
