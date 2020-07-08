package ru.job4j.mockito;

import ru.job4j.fileservlet.model.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ValidateStub implements Validate {
    private final Map<Integer, User> store = new HashMap<>();
    private int ids = 0;

    @Override
    public User add(User user) {
        user.setId(this.ids++);
        this.store.put(user.getId(), user);
        return user;
    }

    @Override
    public User edit(User user) {
        user.setId(this.ids++);
        this.store.put(user.getId(), user);
        return user;
    }

    @Override
    public User delete(User user) {
        this.store.remove(user.getId(), user);
        return user;
    }

    @Override
    public List<User> getAll() {
        return new ArrayList<User>(this.store.values());
    }

}
