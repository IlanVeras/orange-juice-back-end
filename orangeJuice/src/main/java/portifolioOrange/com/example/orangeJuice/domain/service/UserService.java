package portifolioOrange.com.example.orangeJuice.domain.service;


import portifolioOrange.com.example.orangeJuice.domain.entity.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface UserService {


    List<User> searchByName(String name);

    List<User> searchAll();

    User searchById(UUID id);

   User create(User user);

    User update(UUID id, Map<String, Object> params);

    void delete(UUID id);


}
