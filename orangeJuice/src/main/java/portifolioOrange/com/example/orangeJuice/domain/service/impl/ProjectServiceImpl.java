package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.exception.ProjectNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.repository.ProjectRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ProjectService;
import portifolioOrange.com.example.orangeJuice.domain.service.TagService;

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
        Project projectToUpdate = projectRepository.findById(id).orElseThrow(() -> new ProjectNotFoundException(id));

        projectToUpdate.setTitleProject(params.getOrDefault("titleProject", projectToUpdate.getTitleProject()).toString());
        projectToUpdate.setLink(params.getOrDefault("link", projectToUpdate.getLink()).toString());
        projectToUpdate.setDescription(params.getOrDefault("description", projectToUpdate.getDescription()).toString());

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




}
