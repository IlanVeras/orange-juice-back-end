package portifolioOrange.com.example.orangeJuice.app.api.dto.request.user;



import com.fasterxml.jackson.annotation.JsonProperty;
 import io.swagger.v3.oas.annotations.media.Schema;
 import jakarta.validation.constraints.NotBlank;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;

import java.util.List;

@Schema(hidden = true)
public class CreateUserRequest {
    @NotBlank
    @JsonProperty("name")
    private String name;
    @NotBlank
    @JsonProperty("surname")
    private String surname;

    @NotBlank
    @JsonProperty("nacionalidade")
    private String nacionalidade;
    @NotBlank
    @JsonProperty("email")
    private String email;
    @NotBlank
    @JsonProperty("password")
    private String password;

    @JsonProperty("Project")
    private List<Project> projects;
}