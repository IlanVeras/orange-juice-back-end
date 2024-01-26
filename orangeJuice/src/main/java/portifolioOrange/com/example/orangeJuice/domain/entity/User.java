package portifolioOrange.com.example.orangeJuice.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "user")
@Table(name = "users")
@JsonIgnoreProperties
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @Column(length = 50, nullable = false)
    private String name;

    @Column(length = 255, nullable = false)

    private String surname;

    @Column(length = 80, nullable = false)

    private String nacionalidade;



    @Column(length = 255, nullable = false, unique = true)
    private String email;

    @Column(length = 255, nullable = false)
    private String password;
}
