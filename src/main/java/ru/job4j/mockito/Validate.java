package ru.job4j.mockito;

import ru.job4j.dream.store.PsqlStore;
import ru.job4j.dream.store.StoreInt;
import ru.job4j.fileservlet.model.User;

import java.util.List;

public interface Validate {

    User add(User user);

    List<User> getAll();

    public User edit(User user);

    public User delete(User user);
}
