package portifolioOrange.com.example.orangeJuice.app.dto.response.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserResponse {

    private UUID id;

    private Usuario usuario;

    private String titleProject;

    private String link;

    private String description;

    private Date date;

}
