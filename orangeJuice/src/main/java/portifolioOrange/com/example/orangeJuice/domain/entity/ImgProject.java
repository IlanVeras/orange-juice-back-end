package portifolioOrange.com.example.orangeJuice.domain.entity;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.util.Base64;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity(ImgProject= "ImgProject")
@Table(ImgProject = "ImgProject")
@JsonIgnoreProperties
public class ImgProject{

    @Id
    @GeneratedValue(Strategy = GeneretionType.Identity)
    private Integer id;

    @JsonProperty(acess = Acess.WRITE_ONLY)
    @Lob
    @Column 
    private byte[] dados;
    
    @Column 
    private String nome;


    public Integer getId(){
        return id;
    }
    
    public void setId(Integer Id){
        this.id = id;
    }
    
    public byte[] getDados(){
        return dados;
    }
    public void setDados( String dados){
        this.dados = Base64.getDecoder().decode(dados);
        }

    }

    public String getNome(){
        return nome;
    }

public void setNome(String nome){
    this.nome = nome;
}