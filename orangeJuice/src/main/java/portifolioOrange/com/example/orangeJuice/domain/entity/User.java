package portifolioOrange.com.example.orangeJuice.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import portifolioOrange.com.example.orangeJuice.domain.security.SimpleGrantedAuthorityDeserializer;

import java.util.Collection;
import java.util.List;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "user")
@Table(name = "users")
@JsonIgnoreProperties
public class User implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)

    private String surname;

    @Column(length = 255)
    private String nacionalidade;

    @Enumerated
    @Column(length = 50)
    private EnumRole role;

    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;

    @JsonDeserialize(contentUsing = SimpleGrantedAuthorityDeserializer.class)
    private List<GrantedAuthority> authorities;

    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
    private List<Project> projects;
    public User(String name, String surname, String email, String password, EnumRole role) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.role = role;
    }
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        if (this.role == EnumRole.ADMIN) {
            return List.of(new SimpleGrantedAuthority("ROLE_ADMIN"), new SimpleGrantedAuthority("ROLE_USER"));
        } else {
            return List.of(new SimpleGrantedAuthority("ROLE_USER"));
        }
    }
    @Override
    public String getUsername() {
        return email;
    }
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
