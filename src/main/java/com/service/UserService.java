package com.service;

import com.model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    public List<User> findAll();

    public Optional<User> findById(Long id);

    public void add(User user);

    public Optional<User> delete(Long id);

    public Optional<User> update(User user);
}
