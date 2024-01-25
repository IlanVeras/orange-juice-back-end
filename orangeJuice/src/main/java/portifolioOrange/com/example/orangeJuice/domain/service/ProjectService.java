package portifolioOrange.com.example.orangeJuice.domain.service;


import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ProjectService {
    List<Project> searchAll();

    Optional<Project> searchById(UUID id);

    User create(Project project);

    User update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
