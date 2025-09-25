package se.jensen.johanna.library;

public class Library {
    private BookRepository bookRepo;

    public Library(BookRepository bookRepo) {
        this.bookRepo = bookRepo;

    }

    public void showLibraryBooks() {
        bookRepo.printAllBooks();

    }

    public Book getBookByTitle(String title) {
        return bookRepo.getBookByTitle(title);
    }


}
