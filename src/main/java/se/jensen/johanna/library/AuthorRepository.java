package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class AuthorRepository {
    private final List<Author> authors;

    public AuthorRepository() {
        this.authors = new ArrayList<>();
    }

    public void addAuthor(Author author) {
        authors.add(author);

    }


    public Author getAuthorByName(String firstName, String lastName) {
        for (Author author : authors) {
            if (author.getFirstName().equalsIgnoreCase(firstName)
                    && author.getLastName().equalsIgnoreCase(lastName)) {
                return author;
            } else if (author.getFirstName().equalsIgnoreCase(firstName)
                    || author.getLastName().equalsIgnoreCase(lastName)) {
                return author;
            }
        }
        System.out.println("No Author By That Name");
        return null;
    }

    public void printAllAuthors() {
        for (Author author : authors) {
            System.out.println(author + "\n");
        }
    }

    public List<Author> getAllAuthors() {
        return authors;
    }

    public Author getAuthor() {
        for (Author author : authors) {
            return author;
        }
        return null;
    }

    public Author getAuthorByFirstOrLastName(String name) {
        for (Author author : authors) {
            if (author.getFirstName().equalsIgnoreCase(name) || author.getLastName().equalsIgnoreCase(name)) {
                return author;
            }
        }
        System.out.println("No Author with that name");
        return null;

    }

    public void removeAuthor(Author author) {
        authors.remove(author);

    }

    public void addBooksByAuthor(Book book, Author author) {
        author.addBookByAuthor(book);


    }
}
