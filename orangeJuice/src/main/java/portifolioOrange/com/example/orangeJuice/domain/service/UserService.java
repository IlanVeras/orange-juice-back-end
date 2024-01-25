package portifolioOrange.com.example.orangeJuice.domain.service;


import portifolioOrange.com.example.orangeJuice.domain.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface UserService {
    List<User> searchAll();

    Optional<Project> searchById(UUID id);

    User create(User user);

    User update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
