package portifolioOrange.com.example.orangeJuice.domain.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;


import java.util.List;
import java.util.UUID;
@Repository
public interface TagRepository extends JpaRepository<Tag, UUID> {
    boolean existsByNameIgnoreCase(String name);
    boolean findByNameIgnoreCase(String name);
    List<Tag> findByName(String name);
}
