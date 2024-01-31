package portifolioOrange.com.example.orangeJuice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import portifolioOrange.com.example.orangeJuice.domain.entity.ImgProject;

import java.util.UUID;

public interface ImgRepository extends JpaRepository<ImgProject, UUID> {
}
