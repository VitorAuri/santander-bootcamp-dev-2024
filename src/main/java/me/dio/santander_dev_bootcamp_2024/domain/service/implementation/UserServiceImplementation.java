package me.dio.santander_dev_bootcamp_2024.domain.service.implementation;

import me.dio.santander_dev_bootcamp_2024.domain.model.User;
import me.dio.santander_dev_bootcamp_2024.domain.repository.UserRepository;
import me.dio.santander_dev_bootcamp_2024.domain.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class UserServiceImplementation implements UserService {

    @Autowired
    private final UserRepository userRepository;

    public UserServiceImplementation(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id).orElseThrow(NoSuchElementException::new);
    }

    @Override
    public User create(User userToCreate) {
        if (userToCreate != null && userToCreate.getAccount() != null &&
                userRepository.existsByAccountNumber(userToCreate.getAccount().getNumber())) {
            throw new IllegalArgumentException("This user's account number already exists.");
        }
        return userRepository.save(userToCreate);
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }
}
