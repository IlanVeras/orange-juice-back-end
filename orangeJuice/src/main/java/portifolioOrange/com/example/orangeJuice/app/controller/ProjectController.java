package portifolioOrange.com.example.orangeJuice.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;
import portifolioOrange.com.example.orangeJuice.app.ProjectApi;
import portifolioOrange.com.example.orangeJuice.app.dto.request.project.CreateProjectRequest;
import portifolioOrange.com.example.orangeJuice.app.dto.response.project.ProjectResponse;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.service.ProjectService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController implements ProjectApi {
    private final ProjectService projectService;

    private final ObjectMapper mapper;

    public ProjectController(ProjectService projectService, ObjectMapper mapper) {
        this.projectService = projectService;
        this.mapper = mapper;
    }

    private ProjectResponse projectToProductDetailedResponse(Project project){
        return mapper.convertValue(project, ProjectResponse.class);
    }

    @Override
    public ResponseEntity<ProjectResponse> create(CreateProjectRequest request) {
        Project project = mapper.convertValue(request, Project.class);
        Project createdUser = projectService.create(project);

       ProjectResponse projectResponse = projectToProductDetailedResponse(createdProject);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectResponse);
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> searchAll() {
        List<Project> projectList = projectService.searchAll();
        List<ProjectResponse> projectResponseList = projectList.stream()
                .map(project -> new ProjectResponse(project.getId(), project.getUsuario(),project.getTitleProject(),project.getLink(), project.getDate()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(projectResponseList);
    }


    @Override
    public ResponseEntity<ProjectResponse> searchById(UUID id) {
        Optional<Project> project = projectService.searchById(id);

        if (project.isPresent()) {
            ProjectResponse projectResponse = projectToProductDetailedResponse(project.get());
            return ResponseEntity.ok(ProjectResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<ProjectResponse> update(UUID id, Map<String, Object> params) {
        Project  project = projectService.update(id,params);
        ProjectResponse projectResponse = projectToProductDetailedResponse(project);

        return ResponseEntity.accepted().body(ProjectResponse);
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
