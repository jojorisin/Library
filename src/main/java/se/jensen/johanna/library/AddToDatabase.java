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

    public void addUserFromFile() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("users.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] splitNameAndPw = line.split(";");
                String userName = splitNameAndPw[0];
                String pw = splitNameAndPw[1];
                User user = new User(userName, pw);
                User userToAdd = checkForDoubles(user);
                userRepository.addUser(userToAdd);


            }
        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
        }
    }

    public void addAuthorAndBooksFromFile() {
        try (InputStream inputStream = getClass().getClassLoader().getResourceAsStream("books.txt");
             BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream))) {
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
        } catch (NullPointerException | IOException e) {
            System.out.println(e.getMessage());
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

    private User checkForDoubles(User user) {
        for (User existing : userRepository.getAllUsers()) {
            if (existing.getUsername().equalsIgnoreCase(user.getUsername())) {
                return existing;
            }
        }
        return user;
    }


}
