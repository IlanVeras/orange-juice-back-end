package portifolioOrange.com.example.orangeJuice.app.api.dto.response.user;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;

import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private String name;

    private String surname;


    private String nacionalidade;

    private String email;

    private List<Project> projects;

}
