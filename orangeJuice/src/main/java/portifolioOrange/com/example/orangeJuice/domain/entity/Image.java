package portifolioOrange.com.example.orangeJuice.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.sql.Blob;
import java.util.UUID;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name = "ImgProject")
@Table(name = "ImgProject")
@JsonIgnoreProperties
public class Image {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;


    @Lob
    @Column(name = "image", columnDefinition = "LONGTEXT")
    private String image;


}
