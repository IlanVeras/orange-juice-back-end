package portifolioOrange.com.example.orangeJuice.app.api.dto.response.tag;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TagResponse {

    private UUID id;

    private String name;
}
