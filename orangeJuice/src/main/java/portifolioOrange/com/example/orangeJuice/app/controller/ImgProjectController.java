package portifolioOrange.com.example.orangeJuice.app.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import portifolioOrange.com.example.orangeJuice.app.ImgProjectApi;
import portifolioOrange.com.example.orangeJuice.app.dto.request.imgproject.CreateImgProjectRequest;
import portifolioOrange.com.example.orangeJuice.app.dto.response.imgproject.ImgProjectResponse;
import portifolioOrange.com.example.orangeJuice.domain.entity.ImgProject;
import portifolioOrange.com.example.orangeJuice.domain.service.ImgProjectService;
import java.util.Map;
import java.util.UUID;


@RestController
@CrossOrigin(origins = "*")
public class ImgProjectController implements ImgProjectApi{
	
    private final ImgProjectService imgProjectService;
    private final ObjectMapper mapper;
    
    
    public ImgProjectController(ImgProjectService imgProjectService, ObjectMapper mapper) {
        this.imgProjectService = imgProjectService;
        this.mapper = mapper;
    }

    private ImgProjectResponse imgProjectToProductDetailedResponse(ImgProject imgProject) {
        return mapper.convertValue(imgProject, ImgProjectResponse.class);
    }
    
@Override
    public ResponseEntity<ImgProjectResponse> create(CreateImgProjectRequest request) {
        ImgProject imgProject = mapper.convertValue(request, ImgProject.class);
        ImgProject createdImgProject = imgProjectService.create(imgProject);

        ImgProjectResponse imgProjectResponse = imgProjectToProductDetailedResponse(createdImgProject);

        return ResponseEntity.status(HttpStatus.CREATED).body(imgProjectResponse);
    }
    @Override
    public ResponseEntity<ImgProjectResponse> searchById(UUID id) {
        ImgProject imgProject = imgProjectService.searchById(id);
        ImgProjectResponse imgProjectResponse =  imgProjectToProductDetailedResponse(imgProject);

        if(imgProject != null) {
            return ResponseEntity.ok(imgProjectResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ImgProjectResponse> update(UUID id, Map<String, Object> params) {
        ImgProject imgProject = imgProjectService.update(id, params);
        ImgProjectResponse imgProjectResponse = imgProjectToProductDetailedResponse(imgProject);

        if(imgProject != null) {
            return ResponseEntity.accepted().body(imgProjectResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

   @Override
    public ResponseEntity<Void> delete(UUID id) {
        imgProjectService.delete(id);
        return ResponseEntity.noContent().build();
    }
    
   

    
}
