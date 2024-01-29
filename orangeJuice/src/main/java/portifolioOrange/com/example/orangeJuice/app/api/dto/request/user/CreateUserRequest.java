package portifolioOrange.com.example.orangeJuice.app.api.dto.request.user;



import com.fasterxml.jackson.annotation.JsonProperty;
 import io.swagger.v3.oas.annotations.media.Schema;
 import jakarta.validation.constraints.NotBlank;
@Schema(hidden = true)
public class CreateUserRequest {
    @NotBlank
    @JsonProperty("name")
    private String name;
    @NotBlank
    @JsonProperty("surname")
    private String surname;


    @JsonProperty("nacionalidade")
    private String nacionalidade;
    @NotBlank
    @JsonProperty("email")
    private String email;
    @NotBlank
    @JsonProperty("password")
    private String password;

}