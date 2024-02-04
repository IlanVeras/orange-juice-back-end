package portifolioOrange.com.example.orangeJuice.app.api.dto.response.image;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ImageReponse {

    private UUID id;
    private String image;
    private UUID projectId;

}
