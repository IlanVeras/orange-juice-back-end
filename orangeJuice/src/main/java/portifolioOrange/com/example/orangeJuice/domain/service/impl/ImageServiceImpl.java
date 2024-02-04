package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;
import portifolioOrange.com.example.orangeJuice.domain.repository.ImageRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ImageService;

import java.util.*;

@Service
public class ImageServiceImpl implements ImageService {

    @Autowired
    private ImageRepository imageRepository;

    @Override
    public Image create(Image image) {
        return imageRepository.save(image);
    }
    @Override
    public Image update(UUID id, Map<String, Object> params) {
        Optional<Image> optionalImage = imageRepository.findById(id);

        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            if (params.containsKey("imageData")) {
                byte[] newImageData = (byte[]) params.get("imageData");
                image.setImage(Base64.getEncoder().encodeToString(newImageData));
            }

            return imageRepository.save(image);
        } else {
            return null;
        }
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
