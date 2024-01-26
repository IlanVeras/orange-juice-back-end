package portifolioOrange.com.example.orangeJuice.domain.exception;

import jakarta.validation.constraints.Email;

import java.util.UUID;


public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(UUID id) {
        super("%s não encontrando por favor ferificar se o id existe!".formatted(id));
    }
    public UserNotFoundException(String name) {
        super("%s Usuário não encontrado, por favor verifique o nome!".formatted(name));
    }
}

