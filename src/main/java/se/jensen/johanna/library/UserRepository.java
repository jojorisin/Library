package se.jensen.johanna.library;

import java.util.ArrayList;
import java.util.List;

public class UserRepository {
    private final List<User> users;

    public UserRepository() {
        this.users = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public List<User> getAllUsers() {
        return users;
    }

    public void removeUser(User user) {
        users.remove(user);

    }

    public User getUserByUserName(String userName) {
        for (User user : users) {
            if (user.getUsername().equalsIgnoreCase(userName)) {
                return user;
            }

        }
        System.out.println("Cant Find User.");
        return null;
    }


}
