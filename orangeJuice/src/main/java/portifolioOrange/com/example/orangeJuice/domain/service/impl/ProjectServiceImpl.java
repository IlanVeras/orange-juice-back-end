package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.exception.ProjectNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.repository.ProjectRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ProjectService;
import portifolioOrange.com.example.orangeJuice.domain.service.TagService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;

    private final TagService tagService;

    public ProjectServiceImpl(ProjectRepository projectRepository, TagService tagService) {
        this.projectRepository = projectRepository;
        this.tagService = tagService;
    }



    @Override
    public List<Project> searchAll() {
        return projectRepository.findAll();
    }

    @Override
    public Project searchById(UUID id) {
        return projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));

    }


    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }


    @Override
    public Project update(UUID id, Map<String, Object> params) {

        if (id == null || params == null) {

            throw new IllegalArgumentException("ID e parâmetros não podem ser nulos.");
        }

        Project projectToUpdate = projectRepository.findById(id)
                .orElseThrow(() -> new ProjectNotFoundException(id));



        if (params.containsKey("titleProject") && params.get("titleProject") instanceof String) {
            projectToUpdate.setTitleProject((String) params.get("titleProject"));
        }


        if (params.containsKey("link") && params.get("link") instanceof String) {
            projectToUpdate.setLink((String) params.get("link"));
        }


        if (params.containsKey("description") && params.get("description") instanceof String) {
            projectToUpdate.setDescription((String) params.get("description"));
        }


        if (params.containsKey("date") && params.get("date") instanceof LocalDateTime) {
            projectToUpdate.setDate((LocalDateTime) params.get("date"));
        }


        if (params.containsKey("user") && params.get("user") instanceof User) {
            projectToUpdate.setUser((User) params.get("user"));
        }


        if (params.containsKey("tags") && params.get("tags") instanceof List) {
            projectToUpdate.setTags((List<Tag>) params.get("tags"));
        }


        return projectRepository.save(projectToUpdate);
    }

    @Override
    public void delete(UUID id) {
        projectRepository.findById(id).ifPresent(projectRepository::delete);
    }

    @Override
    public List<Project> searchByName(String titleProject) {
        List<Project> projects = projectRepository.findByTitleProject(titleProject);
        if (projects.isEmpty()) {
            throw new ProjectNotFoundException(titleProject);
        }
        return projects;
    }

    @Override
    public List<Project> findByTags_Name(String tagName) {
        return projectRepository.findByTags_Name(tagName);
    }


}
