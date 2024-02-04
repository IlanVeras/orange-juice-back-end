package portifolioOrange.com.example.orangeJuice.app.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;
import portifolioOrange.com.example.orangeJuice.domain.service.ImageService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;

import java.io.IOException;

import java.util.*;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @GetMapping("/ping")
    public String ping() {
        return "Hello World!";
    }


    @GetMapping("/{id}")
    public ResponseEntity<byte[]> displayImage(@PathVariable UUID id) {
        Optional<Image> optionalImage = imageService.viewById(id);

        if (optionalImage.isPresent()) {
            Image image = optionalImage.get();
            String base64EncodedImage = image.getImage();

            try {
                byte[] decodedImage = Base64.getDecoder().decode(base64EncodedImage);

                HttpHeaders headers = new HttpHeaders();
                headers.setContentType(MediaType.IMAGE_JPEG);

                return ResponseEntity.ok().headers(headers).body(decodedImage);
            } catch (IllegalArgumentException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Invalid base64 string".getBytes());
            }
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Image not found".getBytes());
        }
    }



    @GetMapping("")
    public ResponseEntity<List<Image>> getAllImages() {
        List<Image> imageList = imageService.viewAll();
        return ResponseEntity.ok().body(imageList);
    }
        @PostMapping("/add")
        public ResponseEntity<String> addImage(@RequestParam("image") MultipartFile file) {
            try {
                byte[] bytes = file.getBytes();
                String base64EncodedImage = Base64.getEncoder().encodeToString(bytes);

                Image image = new Image();
                image.setImage(base64EncodedImage);
                imageService.create(image);

                return ResponseEntity.status(HttpStatus.CREATED).body("Image added successfully.");
            } catch (IOException e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Failed to add image.");
            }
        }


}
