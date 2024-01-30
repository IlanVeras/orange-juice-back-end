package portifolioOrange.com.example.orangeJuice.domain.security.authConfiguration;

import portifolioOrange.com.example.orangeJuice.domain.entity.EnumRole;

public record CreateRegister(String name, String surname,String nacionalidade ,String email, String password, EnumRole role) {
}
