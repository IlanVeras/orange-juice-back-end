package portifolioOrange.com.example.orangeJuice;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "Orange Aplication", version = "v1", description = "Api desenvolvida para o projeto Orange Portifolio feito na 5ª edicação do Hackathon da Orange Juice"))
public class OrangeJuiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OrangeJuiceApplication.class, args);
	}

}
