package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import org.springframework.stereotype.Service;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.exception.TagNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.repository.TagRepository;
import portifolioOrange.com.example.orangeJuice.domain.service.TagService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
@Service
public class TagServiceImpl implements TagService {

    private final TagRepository tagRepository;

    public TagServiceImpl(TagRepository tagRepository) {
        this.tagRepository = tagRepository;
    }

    @Override
    public List<Tag> searchAll() {
        return tagRepository.findAll();
    }

    @Override
    public boolean findByNameIgnoreCase(String name) {
        return tagRepository.findByNameIgnoreCase(name);
    }

    @Override
    public Tag searchById(UUID id) {
        return tagRepository.findById(id).orElseThrow(() -> new TagNotFoundException(id));
    }

    @Override
    public List<Tag> searchByName(String name) {
        List<Tag> tags = tagRepository.findByName(name);
        if (tags.isEmpty()) {
            throw new TagNotFoundException(name);
        }
        return tags;
    }


    @Override
    public Tag create(Tag tag) {

        if (tagRepository.existsByNameIgnoreCase(tag.getName())) {
            throw new TagNotFoundException(tag.getName());
        }


        return tagRepository.save(tag);
    }
    @Override
    public Tag update(UUID id, Map<String, Object> params) {
        if (id == null || params == null) {
            throw new IllegalArgumentException("ID e parâmetros não podem ser nulos.");
        }

        Tag tagToUpdate = tagRepository.findById(id).orElseThrow(() -> new TagNotFoundException(id));

        if (params.containsKey("name") && params.get("name") instanceof String) {
            String name = (String) params.get("name");
            if (!name.trim().isEmpty()) {
                tagToUpdate.setName(name.trim());
            }
        }

        return tagRepository.save(tagToUpdate);
    }





    @Override
    public void delete(UUID id) {
        tagRepository.findById(id).ifPresent(tagRepository::delete);

    }



}
