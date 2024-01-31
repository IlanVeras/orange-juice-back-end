package portifolioOrange.com.example.orangeJuice.domain.service;


import portifolioOrange.com.example.orangeJuice.domain.entity.Project;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public interface ProjectService {


    List<Project> searchAll();

    Project searchById(UUID id);

    Project create(Project project);

    Project update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
