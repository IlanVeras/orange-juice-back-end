package portifolioOrange.com.example.orangeJuice.app.api.dto.response.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProjectResponse {

    private UUID id;

    private String titleProject;

    private String link;

    private String description;

    private LocalDateTime date;

}
