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
@Entity(project= "project")
@Table(project = "projects")
@JsonIgnoreProperties
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotNull
    @ManyToOne
    @Column(length = 255, nullable = false)
    private User user;

    @Column(length = 255, nullable = false)
    private String titleProject;


    @Column(nullable = false)
    private String link;

    @Column(length = 255, nullable = false)
    private String description;

    @Column (length = 8, nullable = false )
    @DateTimeFormat(pattern = "yyyy-MM-dd hh:mm:ss")
    private Date date;
}
