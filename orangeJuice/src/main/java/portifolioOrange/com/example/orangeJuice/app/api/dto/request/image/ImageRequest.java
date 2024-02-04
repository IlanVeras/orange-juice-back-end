package portifolioOrange.com.example.orangeJuice.app.api.dto.request.image;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;

import java.util.UUID;

@Schema(hidden = true)
public class ImageRequest {

    @NotBlank
    @JsonProperty("image")
    private String image;
    @NotBlank
    @JsonProperty("projectId")
    private UUID projectId;

}