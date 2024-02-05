package portifolioOrange.com.example.orangeJuice.domain.service.impl;


import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
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
    public User update(UUID id, Map<String, Object> params) {
        if (id == null || params == null) {
            throw new UserNotFoundException(id);
        }

        User userToUpdate = userRepository.findById(id)
                .orElseThrow(() -> new UserNotFoundException(id));

        userToUpdate.setName(params.containsKey("name") && params.get("name") instanceof String
                ? ((String) params.get("name")).trim() : userToUpdate.getName());

        userToUpdate.setSurname(params.containsKey("surname") && params.get("surname") instanceof String
                ? ((String) params.get("surname")).trim() : userToUpdate.getSurname());

        userToUpdate.setNacionalidade(params.containsKey("nacionalidade") && params.get("nacionalidade") instanceof String
                ? ((String) params.get("nacionalidade")).trim() : userToUpdate.getNacionalidade());

        userToUpdate.setEmail(params.containsKey("email") && params.get("email") instanceof String
                ? ((String) params.get("email")).trim() : userToUpdate.getEmail());

        Object passwordParam = params.get("password");
        if (passwordParam != null && passwordParam instanceof String) {
            String password = ((String) passwordParam).trim();
            if (!password.isEmpty()) {
                userToUpdate.setPassword(password);
            }
        }

        if (params.containsKey("projects") && params.get("projects") instanceof List) {
            List<Project> updatedProjects = (List<Project>) params.get("projects");
            userToUpdate.setProjects(updatedProjects);
        }

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
