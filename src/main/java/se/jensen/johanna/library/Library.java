package se.jensen.johanna.library;

public class Library {
    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;

    public Library(BookRepository bookRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;

    }

    public void showLibraryBooks() {
        bookRepository.printAllBooks();

    }

    public Book getBookByTitle(String title) {
        return bookRepository.getBookByTitle(title);
    }

    public Author getAuthorByName(String name) throws NullPointerException {
        String[] authorName = name.split(" ");
        String firstName;
        String lastName;
        if (authorName.length > 2) {
            firstName = authorName[0] + " " + authorName[1];
            lastName = authorName[2];
        } else if (authorName.length == 1) {
            if (authorRepository.getAuthorByFirstOrLastName(authorName[0]) != null) {
                return authorRepository.getAuthorByFirstOrLastName(authorName[0]);
            } else {
                throw new NullPointerException("Cant Find Author");
            }
        }
        firstName = authorName[0];
        lastName = authorName[1];
        if (authorRepository.getAuthorByName(firstName, lastName) == null) {
            throw new NullPointerException("Cant Find Author");

        } else {
            return authorRepository.getAuthorByName(firstName, lastName);
        }
    }

}



