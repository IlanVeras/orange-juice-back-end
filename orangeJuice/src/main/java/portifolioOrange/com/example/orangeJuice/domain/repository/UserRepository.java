package portifolioOrange.com.example.orangeJuice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;


import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, UUID> {

}
