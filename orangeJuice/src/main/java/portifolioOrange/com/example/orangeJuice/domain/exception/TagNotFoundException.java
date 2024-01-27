package portifolioOrange.com.example.orangeJuice.domain.exception;

import java.util.UUID;

public class TagNotFoundException extends RuntimeException{

    private final String errorMessage;
    private final boolean isBadRequest;

    public TagNotFoundException(UUID id) {
        this.errorMessage = "A Tag não pôde ser encontrada. Certifique-se de fornecer um identificador válido.";
        this.isBadRequest = false;
    }

    public TagNotFoundException(String name) {
        this.errorMessage = "A Tag não pôde ser encontrada. Certifique-se de fornecer um nome de tag válido.";
        this.isBadRequest = true;
    }

    public String getErrorMessage() {
        return errorMessage;
    }

    public boolean isBadRequest() {
        return isBadRequest;
    }
}
