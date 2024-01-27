package portifolioOrange.com.example.orangeJuice.domain.exception;

import java.util.UUID;

public class UserNotFoundException extends RuntimeException {

    public UserNotFoundException(UUID id) {
        super(id + " não encontrado, por favor verificar se o id existe!");
    }
    public UserNotFoundException(String name) {
        super(name + " Usuário não encontrado, por favor verifique o nome!");
    }
}


