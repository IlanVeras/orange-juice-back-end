package portifolioOrange.com.example.orangeJuice.app.dto.request.project;

import java.sql.Date;

import javax.print.attribute.standard.DateTimeAtCompleted;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

@Schema(hidden = true)
public class CreateProjectRequest {
    @NotBlank
    @JsonProperty("usuario")
    private Usuario usuario;

    @NotBlank
    @JsonProperty("titleProject")
    private String titleProject;

    @NotBlank
    @JsonProperty("link")
    private String link;

    @NotBlank
    @JsonProperty("description")
    private String description;
    
    @NotBlank
    @JsonProperty("date")
    private Date date;

}