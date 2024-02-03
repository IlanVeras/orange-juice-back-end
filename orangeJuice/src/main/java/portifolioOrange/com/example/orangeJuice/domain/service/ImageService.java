package portifolioOrange.com.example.orangeJuice.domain.service;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public interface ImageService {
    Image create(Image image);
    List<Image> viewAll();
    Optional<Image> viewById(UUID id);


}
