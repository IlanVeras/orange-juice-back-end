package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Image;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;
import portifolioOrange.com.example.orangeJuice.domain.exception.ProjectNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.repository.ImageRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.ProjectRepository;
import portifolioOrange.com.example.orangeJuice.domain.repository.TagRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.ProjectService;
import portifolioOrange.com.example.orangeJuice.domain.service.TagService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class ProjectServiceImpl implements ProjectService {

    private final ProjectRepository projectRepository;
    private final TagRepository tagRepository;

    private final ImageRepository imageRepository;

    private final TagService tagService;

    public ProjectServiceImpl(ProjectRepository projectRepository, TagRepository tagRepository, ImageRepository imageRepository, TagService tagService) {
        this.projectRepository = projectRepository;
        this.tagRepository = tagRepository;
        this.imageRepository = imageRepository;
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
            String titleProject = (String) params.get("titleProject");
            if (!titleProject.trim().isEmpty()) {
                projectToUpdate.setTitleProject(titleProject.trim());
            }
        }

        if (params.containsKey("link") && params.get("link") instanceof String) {
            String link = (String) params.get("link");
            if (!link.trim().isEmpty()) {
                projectToUpdate.setLink(link.trim());
            }
        }

        if (params.containsKey("description") && params.get("description") instanceof String) {
            String description = (String) params.get("description");
            if (!description.trim().isEmpty()) {
                projectToUpdate.setDescription(description.trim());
            }
        }

        if (params.containsKey("date") && params.get("date") instanceof LocalDateTime) {
            projectToUpdate.setDate((LocalDateTime) params.get("date"));
        }

        if (params.containsKey("user") && params.get("user") instanceof User) {
            projectToUpdate.setUser((User) params.get("user"));
        }

        if (params.containsKey("tags") && params.get("tags") instanceof List) {
            List<Map<String, Object>> tagList = (List<Map<String, Object>>) params.get("tags");
            List<Tag> updatedTags = new ArrayList<>();

            for (Map<String, Object> tagMap : tagList) {
                if (tagMap.containsKey("name") && tagMap.get("name") instanceof String) {
                    String tagName = (String) tagMap.get("name");


                    List<Tag> existingTags = tagRepository.findByName(tagName);


                    Tag tag = existingTags.isEmpty() ? new Tag(UUID.randomUUID(), tagName) : existingTags.get(0);

                    updatedTags.add(tag);
                }
            }

            projectToUpdate.setTags(updatedTags);
        }

        if (params.containsKey("images") && params.get("images") instanceof List) {
            List<Map<String, Object>> imageList = (List<Map<String, Object>>) params.get("images");
            List<Image> updatedImages = new ArrayList<>();

            for (Map<String, Object> imageMap : imageList) {
                if (imageMap.containsKey("image") && imageMap.get("image") instanceof String) {
                    String image = (String) imageMap.get("image");


                    List<Image> existingImages = imageRepository.findByImage(image);


                    Image image1 = existingImages.isEmpty() ? new Image(UUID.randomUUID(), image) : existingImages.get(0);

                    updatedImages.add(image1);
                }
            }

            projectToUpdate.setImages(updatedImages);
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
