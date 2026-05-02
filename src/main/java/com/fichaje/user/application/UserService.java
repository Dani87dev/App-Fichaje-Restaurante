package com.fichaje.user.application;

import com.fichaje.user.domain.model.User;
import com.fichaje.user.domain.port.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User createUser(User user) {
        return repo.save(user);
    }

    public User findById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
    }

    public User findByEmail(String email) {
        return repo.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User not found with email: " + email));
    }

    public List<User> findAll() {
        return repo.findAll();
    }

    public User updateUser(Long id, User updatedData) {
        User existing = findById(id);
        existing.setName(updatedData.getName());
        existing.setEmail(updatedData.getEmail());
        existing.setRol(updatedData.getRol());
        existing.setSector(updatedData.getSector());
        existing.setActualEmployed(updatedData.isActualEmployed());
        return repo.save(existing);
    }

    public void deleteUser(Long id) {
        findById(id);
        repo.deleteById(id);
    }

}
