package org.example.repository;

import org.example.model.User;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class UserRepository {

    private static Map<String, User> userMap = new HashMap<>();

    public boolean saveUser(User user) {
        boolean contains = userMap.containsKey(user.getLogin());
        if (!contains) {
            userMap.put(user.getLogin(), user);
        }
        return !contains;
    }

    public Optional<User> getUser(String login) {
        User user = userMap.get(login);
        if (user == null) {
            return Optional.empty();
        }
        return Optional.of(user);
    }
}
