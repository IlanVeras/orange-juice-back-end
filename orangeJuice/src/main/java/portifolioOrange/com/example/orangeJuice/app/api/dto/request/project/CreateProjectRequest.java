package portifolioOrange.com.example.orangeJuice.app.api.dto.request.project;


import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;

import java.time.LocalDateTime;
import java.util.List;

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


    @JsonProperty("user")
    private User idUSer;

    @JsonProperty("tags")
    private List<Tag> tags;

    @JsonProperty("images")
    private List<Image> images;

}