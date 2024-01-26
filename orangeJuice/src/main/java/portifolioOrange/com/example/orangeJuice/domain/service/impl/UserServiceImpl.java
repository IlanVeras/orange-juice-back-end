package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.exception.UserNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.repository.UserRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.UserService;

import java.util.*;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> searchAll() {
        return userRepository.findAll();
    }

    @Override
    public User searchById(UUID id) {
        return userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }
    

    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(UUID id, Map<String, Object> params) {
        User userToUpdate = userRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));

        userToUpdate.setName(params.getOrDefault("name", userToUpdate.getName()).toString());
        userToUpdate.setSurname(params.getOrDefault("surname", userToUpdate.getSurname()).toString());
        userToUpdate.setEmail(params.getOrDefault("email", userToUpdate.getEmail()).toString());
        userToUpdate.setPassword(params.getOrDefault("password", userToUpdate.getPassword()).toString());

        return userRepository.save(userToUpdate);
    }

    @Override
    public void delete(UUID id) {
        userRepository.findById(id).ifPresent(userRepository::delete);
    }


    @Override
    public List<User> searchByName(String name) {
        List<User> users = userRepository.findByName(name);
        if (users.isEmpty()) {
            throw new UserNotFoundException(name);
        }
        return users;
    }


}
