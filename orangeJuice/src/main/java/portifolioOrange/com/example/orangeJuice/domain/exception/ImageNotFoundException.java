package portifolioOrange.com.example.orangeJuice.domain.exception;

import java.util.UUID;

public class ImageNotFoundException extends Throwable {

    public ImageNotFoundException(UUID id) {
        super(id + " não encontrado, por favor verificar se o id existe!");
    }
    public ImageNotFoundException(String name) {
        super(name + " Usuário não encontrado, por favor verifique o nome!");
    }
}
