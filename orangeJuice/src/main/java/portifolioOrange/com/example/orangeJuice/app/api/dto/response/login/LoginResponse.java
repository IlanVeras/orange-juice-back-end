package portifolioOrange.com.example.orangeJuice.app.api.dto.response.login;

import portifolioOrange.com.example.orangeJuice.domain.entity.Project;

import java.util.List;
import java.util.UUID;

public record LoginResponse(String token, String name, String surname, String nacionalidade,UUID id, String email, List<Project> projects) {
}
