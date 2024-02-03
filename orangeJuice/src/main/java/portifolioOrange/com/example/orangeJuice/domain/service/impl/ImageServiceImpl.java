package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;
import portifolioOrange.com.example.orangeJuice.domain.repository.ImageRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ImageService;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }

    @Override
    public List<Image> viewAll() {
        return (List<Image>) imageRepository.findAll();
    }

    @Override
    public Optional<Image> viewById(UUID id) {
        return imageRepository.findById(id);
    }
}
