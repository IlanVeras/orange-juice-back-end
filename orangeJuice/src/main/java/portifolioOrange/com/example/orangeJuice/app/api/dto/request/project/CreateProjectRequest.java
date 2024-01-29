package portifolioOrange.com.example.orangeJuice.app.api.dto.request.project;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

@Schema(hidden = true)
public class CreateProjectRequest {


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
    private LocalDateTime date;


}