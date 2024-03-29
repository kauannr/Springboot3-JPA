package com.projeto.curso.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.projeto.curso.repositories.UserRepository;
import com.projeto.curso.Services.ServicesExceptions.DatabaseException;
import com.projeto.curso.Services.ServicesExceptions.getException;
import com.projeto.curso.entities.User;;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> findAll() {
        return userRepository.findAll();
    }

    public User findById(Long id) {
        Optional<User> obj = userRepository.findById(id);
        return obj.orElseThrow(() -> new getException(id));
    }

    public User insertUser(User user) {
        return userRepository.save(user);
    }

    public void deleteUser(Long id) {
        try {
            userRepository.deleteById(id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException(e.getMessage());
        }
    }

    public User updateUser(long id, User newUser) {
        User oldUser = userRepository.getReferenceById(id);
        updateData(oldUser, newUser);
        return userRepository.save(oldUser);
    }

    // complemento updateUser
    private static void updateData(User oldUser, User newUser) {
        oldUser.setName(newUser.getName());
        oldUser.setEmail(newUser.getEmail());
        oldUser.setPhone(newUser.getPhone());
    }
}
