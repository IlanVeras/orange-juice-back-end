package portifolioOrange.com.example.orangeJuice.app.dto.response.project;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.springframework.boot.autoconfigure.security.SecurityProperties.User;

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
