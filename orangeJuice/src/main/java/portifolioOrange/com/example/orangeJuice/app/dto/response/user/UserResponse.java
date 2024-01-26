package portifolioOrange.com.example.orangeJuice.app.dto.response.user;

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

    private String name;

    private String surname;


    private String nacionalidade;

    private String email;


}
