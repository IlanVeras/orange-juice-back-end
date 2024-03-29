package portifolioOrange.com.example.orangeJuice.domain.service;

import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TagService {

    List<Tag> searchAll();
    boolean findByNameIgnoreCase(String name);
    Tag searchById(UUID id);
    List<Tag> searchByName(String name);
    Tag create(Tag tag);

    Tag update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
