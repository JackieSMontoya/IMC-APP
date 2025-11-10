package com.example.service;

import com.example.model.User;
import com.example.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepo;

    public UserService(UserRepository userRepo) {
        this.userRepo = userRepo;
    }

    public User register(User user) throws Exception {
        if (user.getAge() < 15)
            throw new Exception("Edad mínima inválida");
        if (user.getHeight() < 1 || user.getHeight() > 2.5)
            throw new Exception("Altura inválida");

        return userRepo.save(user);
    }

    public Optional<User> login(String username, String password) {
        return userRepo.findByUsername(username)
                .filter(u -> u.getPassword().equals(password));
    }
}
