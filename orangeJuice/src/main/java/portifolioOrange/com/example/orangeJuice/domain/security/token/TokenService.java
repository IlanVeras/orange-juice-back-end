package portifolioOrange.com.example.orangeJuice.domain.security.token;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

@Service
public class TokenService {

    @Value("${api.security.token.secret}")
    private String secret;
    public String generateToken(User user){

        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            String token = JWT.create()
                    .withIssuer("rent-car")
                    .withSubject(user.getEmail())
                    .withExpiresAt(genExpirationDate())
                    .sign(algorithm);

            return token;

        }catch (JWTCreationException exception){
            throw new RuntimeException("Error while generating token", exception);
        }

    }

    public String validateToken(String token){
        try {
            Algorithm algorithm = Algorithm.HMAC256(secret);
            return JWT.require(algorithm)
                    .withIssuer("rent-car") //criador
                    .build() //
                    .verify(token)//descriptografa
                    .getSubject(); //pega o token

        }catch (JWTVerificationException exception){
            return "";
        }

    }

    private Instant genExpirationDate(){
        return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
    }

}