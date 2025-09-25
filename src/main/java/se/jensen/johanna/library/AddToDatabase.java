package se.jensen.johanna.library;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class AddToDatabase {
    BookRepository bookRepository;
    AuthorRepository authorRepository;
    UserRepository userRepository;

    public AddToDatabase(BookRepository bookRepository, UserRepository userRepository, AuthorRepository authorRepository) {
        this.bookRepository = bookRepository;
        this.userRepository = userRepository;
        this.authorRepository = authorRepository;
    }

    public void addAuthorAndBooksFromFile() {
        InputStream inputStream = getClass().getClassLoader().getResourceAsStream("books.txt");
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(";");
                String title = parts[0];
                String[] authorName = parts[1].split(" ");
                String firstName;
                String lastName;
                if (authorName.length > 2) {
                    firstName = authorName[0] + " " + authorName[1];
                    lastName = authorName[2];

                } else {
                    firstName = authorName[0];
                    lastName = authorName[1];

                }

                //check double innan
                Author newAuthor = new Author(firstName, lastName);
                Author authorToAdd = checkForDoubles(newAuthor);
                String isbn = parts[2];
                String genre = parts[3];
                Book book = new Book(title, authorToAdd, isbn, genre);

                if (!authorRepository.getAllAuthors().contains(authorToAdd)) {
                    authorRepository.addAuthor(authorToAdd);
                }

                bookRepository.addBook(book);
                authorToAdd.addBookByAuthor(book);


            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private Author checkForDoubles(Author author) {
        for (Author existing : authorRepository.getAllAuthors()) {
            if (existing.getFirstName().equalsIgnoreCase(author.getFirstName()) &&
                    existing.getLastName().equalsIgnoreCase(author.getLastName())) {
                return existing;
            }
        }
        return author;
    }


}
