package portifolioOrange.com.example.orangeJuice.domain.entity;

import org.springframework.security.core.GrantedAuthority;

public enum EnumRole implements GrantedAuthority {
    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");



    private  String authority;

    EnumRole(String authority) {
        this.authority = authority;
    }

    @Override
    public String getAuthority() {
        return authority;
    }
}
