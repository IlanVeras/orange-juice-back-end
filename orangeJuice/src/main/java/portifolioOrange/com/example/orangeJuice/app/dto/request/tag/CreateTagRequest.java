package portifolioOrange.com.example.orangeJuice.app.dto.request.tag;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.constraints.NotBlank;

public class CreateTagRequest {

    @NotBlank
    @JsonProperty("name")
    private String name;


}
