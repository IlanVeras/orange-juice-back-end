package portifolioOrange.com.example.orangeJuice.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Base64;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(name= "ImgProject")
@Table(name = "ImgProject")
@JsonIgnoreProperties
public class ImgProject{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;



    @Lob
    private byte[] data;



}

