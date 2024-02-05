package portifolioOrange.com.example.orangeJuice.app.api;

import io.swagger.v3.oas.annotations.Operation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;

import java.util.List;
import java.util.UUID;

@RequestMapping("/api/images")
public interface ImageApi {


    @Operation(summary = "Search/Display image by id", method = "GET")
    @GetMapping("/{id}")
    ResponseEntity<byte[]> displayImage(@PathVariable UUID id);

    @Operation(summary = "Update image by id", method = "PUT")
    @PutMapping("/update/{id}")
    ResponseEntity<String> updateImage(@PathVariable UUID id, @RequestParam("image") MultipartFile file);

    @Operation(summary = "Search all Images", method = "GET")
    @GetMapping("")
    ResponseEntity<List<Image>> getAllImages();

    @Operation(summary = "Create a new Image in base64", method = "POST")
    @PostMapping("/add")
    ResponseEntity<String> addImage(@RequestParam("image") MultipartFile file);
}
