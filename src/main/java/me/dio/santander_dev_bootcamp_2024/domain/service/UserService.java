package me.dio.santander_dev_bootcamp_2024.domain.service;

import me.dio.santander_dev_bootcamp_2024.domain.model.User;

import java.util.List;

public interface UserService {

    User findById(Long id);

    User create(User userToCreate);

    List<User> findAll();

}
