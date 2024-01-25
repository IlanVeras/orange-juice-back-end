package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.repository.ProjectRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ProjectService;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository ProjectRepository;

    public ProjectServiceImpl(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    //TRAZER TODOS os projetos
    @Override
    public List<Project> searchAll() {
        return projectRepository.findAll();
    }
    // TRAZER os projetos por ID
    @Override
    public Optional<Project> searchById(UUID id) {
        return projectRepository.findById(id);
    }

    //CRIAR novos projetos na API
    @Override
    public Project create(Project project) {
        return projectRepository.save(project);
    }

    //ATUALIZAR dados do projeto
    public Project update(UUID id, Map<String, Object> params) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalproject.ifPresent(project -> {
            project.setTitleProject(params.getOrDefault("titleProject", project.getTitleProject()).toString());
            project.setLink(params.getOrDefault("link", project.getLink()).toString());
            project.setDescription(params.getOrDefault("description", project.getDescription()).toString());
        });

        return optionalProject.orElse(null);
    }
    //DELETAR projeto por ID
    @Override
    public void delete(UUID id) {
        Optional<Project> optionalProject = projectRepository.findById(id);

        optionalProject.ifPresent(project -> {
            projectRepository.delete(project);
        });
    }

}
