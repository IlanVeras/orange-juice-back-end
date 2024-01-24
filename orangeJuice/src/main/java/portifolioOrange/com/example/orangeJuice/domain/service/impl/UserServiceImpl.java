package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.repository.UserRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.UserService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

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
    public Optional<User> searchById(UUID id) {
        return userRepository.findById(id);
    }


    @Override
    public User create(User user) {
        return userRepository.save(user);
    }

    public User update(UUID id, Map<String, Object> params) {
        Optional<User> optionalUser = userRepository.findById(id);

        optionalUser.ifPresent(user -> {
            user.setSurname(params.getOrDefault("name", user.getSurname()).toString());
            user.setSurname(params.getOrDefault("surname", user.getSurname()).toString());
            user.setEmail(params.getOrDefault("email", user.getEmail()).toString());
            user.setPassword(params.getOrDefault("password", user.getPassword()).toString());
        });

        return optionalUser.orElse(null);
    }

    @Override
    public void delete(UUID id) {
        Optional<User> optionalUser = userRepository.findById(id);

        optionalUser.ifPresent(user -> {
            userRepository.delete(user);
        });
    }

}
