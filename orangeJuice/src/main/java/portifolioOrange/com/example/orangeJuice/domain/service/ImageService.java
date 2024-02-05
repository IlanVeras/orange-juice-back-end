package portifolioOrange.com.example.orangeJuice.domain.service;

import portifolioOrange.com.example.orangeJuice.domain.entity.Image;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;


public interface ImageService {
    Image create(Image image);

    Image update(UUID id, Map<String, Object> params);
    List<Image> viewAll();
    Optional<Image> viewById(UUID id);

    List<Image> findByName(String name);
}
