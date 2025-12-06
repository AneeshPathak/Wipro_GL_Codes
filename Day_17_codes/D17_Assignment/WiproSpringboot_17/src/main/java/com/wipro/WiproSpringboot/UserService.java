package com.wipro.WiproSpringboot;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

@Service
public class UserService {

    private final Map<Integer, User> users = new ConcurrentHashMap<>();
    private final AtomicInteger idGen = new AtomicInteger(1);

    public UserService() {
        // add a default user for login testing: username: user, password: pass
        User u = new User(idGen.getAndIncrement(), "user", "pass", "Default User", "user@example.com");
        users.put(u.getId(), u);
    }

    public User authenticate(String username, String password) {
        for (User u : users.values()) {
            if (u.getUsername().equals(username) && u.getPassword().equals(password)) {
                return u;
            }
        }
        return null;
    }

    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    public User findById(int id) {
        return users.get(id);
    }

    public User register(User u) {
        int id = idGen.getAndIncrement();
        u.setId(id);
        users.put(id, u);
        return u;
    }

    public boolean delete(int id) {
        return users.remove(id) != null;
    }

    public User update(User u) {
        if (u == null || u.getId() == 0) return null;
        users.put(u.getId(), u);
        return u;
    }
}
