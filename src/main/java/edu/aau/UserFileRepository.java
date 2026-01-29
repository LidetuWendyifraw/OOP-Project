package edu.aau;

import java.io.*;
import java.util.*;

public class UserFileRepository implements UserRepository {
    private final String FILE_NAME = "users.txt";

    public UserFileRepository() {
        File file = new File(FILE_NAME);
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void save(User user) {
        // CRUD: Create/Update logic
        System.out.println("Saving user to file: " + user.getUsername());
    }

    @Override
    public User findByUsername(String username) {
            // CRUD: Read logic
        return null; 
    }

    @Override
    public List<User> findAll() {
        return new ArrayList<>();
    }
}
