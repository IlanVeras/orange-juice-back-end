package portifolioOrange.com.example.orangeJuice.app.api.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portifolioOrange.com.example.orangeJuice.app.api.ProjectApi;
import portifolioOrange.com.example.orangeJuice.app.api.dto.request.project.CreateProjectRequest;
import portifolioOrange.com.example.orangeJuice.app.api.dto.response.project.ProjectResponse;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.exception.ProjectNotFoundException;

import portifolioOrange.com.example.orangeJuice.domain.repository.TagRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ProjectService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class ProjectController implements ProjectApi {
    private final ProjectService projectService;
    private final TagRepository tagRepository;
    private final ObjectMapper mapper;

    public ProjectController(ProjectService projectService, TagRepository tagRepository, ObjectMapper mapper) {
        this.projectService = projectService;
        this.tagRepository = tagRepository;
        this.mapper = mapper;
    }

    @ExceptionHandler(ProjectNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public ResponseEntity<String> handleProjectNotFoundException(ProjectNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    private ProjectResponse projectToProductDetailedResponse(Project project) {
        return mapper.convertValue(project, ProjectResponse.class);
    }

    @Override
    public ResponseEntity<ProjectResponse> create(CreateProjectRequest request) {
        Project project = mapper.convertValue(request, Project.class);
        Project createdProject = projectService.create(project);

        ProjectResponse projectResponse = projectToProductDetailedResponse(createdProject);

        return ResponseEntity.status(HttpStatus.CREATED).body(projectResponse);
    }

    @Override
    public ResponseEntity<List<ProjectResponse>> searchAll() {
        List<Project> projectList = projectService.searchAll();
        List<ProjectResponse> projectResponseList = projectList.stream()
                .map(project -> {
                    User user = project.getUser();
                    UUID userId = (user != null) ? user.getId() : null;

                    return new ProjectResponse(project.getId(), project.getTitleProject(), project.getLink(), project.getDescription(), project.getDate(), userId, project.getTags());
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(projectResponseList);
    }


    @Override
    public ResponseEntity<ProjectResponse> searchById(UUID id) {
        Project project = projectService.searchById(id);
        ProjectResponse projectResponse =  projectToProductDetailedResponse(project);

        if(project != null) {
            return ResponseEntity.ok(projectResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @Override
    public ResponseEntity<ProjectResponse> update(UUID id, Map<String, Object> params) {
        Project project = projectService.update(id, params);
        ProjectResponse projectResponse = projectToProductDetailedResponse(project);

        if(project != null) {
            return ResponseEntity.accepted().body(projectResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        projectService.delete(id);
        return ResponseEntity.noContent().build();
    }


    @Override
    public ResponseEntity<List<ProjectResponse>> searchByName(@PathVariable String name) {

        List<Project> projectList = projectService.searchByName(name);
        List<ProjectResponse> projectResponseList = projectList.stream()
                .map(project -> {
                    User user = project.getUser();
                    UUID userId = (user != null) ? user.getId() : null;

                    return new ProjectResponse(project.getId(), project.getTitleProject(), project.getLink(), project.getDescription(), project.getDate(), userId, project.getTags());
                })
                .collect(Collectors.toList());

        return ResponseEntity.ok(projectResponseList);
    }

}
