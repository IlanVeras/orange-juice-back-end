package portifolioOrange.com.example.orangeJuice.domain.service;

import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.entity.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public interface TagService {

    List<Tag> searchAll();

    Tag searchById(UUID id);
    List<Tag> searchByName(String name);
    Tag create(Tag tag);

    Tag update(UUID id, Map<String, Object> params);

    void delete(UUID id);
}
