package portifolioOrange.com.example.orangeJuice.domain.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import portifolioOrange.com.example.orangeJuice.domain.entity.ImgProject;

public interface ImgProjectRepository extends JpaRepository<ImgProject,UUID>{

}
