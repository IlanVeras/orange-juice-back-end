package portifolioOrange.com.example.orangeJuice.domain.exception;

import java.util.UUID;

public class ProjectNotFoundException extends RuntimeException{

    public ProjectNotFoundException(UUID id) {
        super("%s não encontrando por favor verificar se o id existe!".formatted(id));
    }
    public ProjectNotFoundException(String titleProject) {
        super(titleProject + " Usuário não encontrado, por favor verifique o nome!");
    }


}