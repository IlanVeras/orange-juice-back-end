package portifolioOrange.com.example.orangeJuice.app.dto.request.imgproject;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.validation.constraints.NotBlank;

public class CreateImgProjectRequest {
    

    @NotBlank
    @JsonProperty("link")
    private String link;
  
	
}
