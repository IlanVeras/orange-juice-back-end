package portifolioOrange.com.example.orangeJuice.domain.security;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
public class SecurityConfigurations {
    @Autowired
    SecurityFilter securityFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) throws Exception{
        return httpSecurity .cors().and()
                .csrf(csrf -> csrf.disable())
                .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authorizeHttpRequests(authorize -> authorize
                        .requestMatchers(HttpMethod.POST, "/auth/login").permitAll()
                        .requestMatchers(HttpMethod.POST, "/auth/register").permitAll()
                        .requestMatchers(HttpMethod.POST, "/v1/products/create").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/v1/products").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/products/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/v1/users").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/v1/users/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/features").authenticated()
                        .requestMatchers(HttpMethod.GET, "/v1/features/{id}").hasRole("ADMIN")
                        .requestMatchers(HttpMethod.GET, "/v1/cities").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/categories").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/categories/{id}").permitAll()
                        .requestMatchers(HttpMethod.GET, "/v1/bookings").authenticated()
                        .requestMatchers(HttpMethod.GET, "/v1/bookings/{id}").authenticated()
                        .requestMatchers(HttpMethod.GET, "/swagger-ui/**").permitAll()

                        .anyRequest().permitAll()
                )
                .addFilterBefore(securityFilter, UsernamePasswordAuthenticationFilter.class)
                .build();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

}


