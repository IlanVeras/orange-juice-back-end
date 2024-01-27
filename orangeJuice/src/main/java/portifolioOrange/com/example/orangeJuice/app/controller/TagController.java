package portifolioOrange.com.example.orangeJuice.app.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portifolioOrange.com.example.orangeJuice.app.TagApi;
import portifolioOrange.com.example.orangeJuice.app.dto.request.tag.CreateTagRequest;
import portifolioOrange.com.example.orangeJuice.app.dto.response.tag.TagResponse;
import portifolioOrange.com.example.orangeJuice.domain.entity.Tag;
import portifolioOrange.com.example.orangeJuice.domain.exception.TagNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.service.TagService;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

@RestController
@CrossOrigin(origins = "*")
public class TagController implements TagApi {
    private final TagService tagService;
    private final ObjectMapper mapper;

    @ExceptionHandler(TagNotFoundException.class)
    public ResponseEntity<String> handleTagNotFoundException(TagNotFoundException ex) {
        HttpStatus status = ex.isBadRequest() ? HttpStatus.BAD_REQUEST : HttpStatus.NOT_FOUND;
        return ResponseEntity.status(status).body(ex.getErrorMessage());
    }
    public TagController(TagService tagService, ObjectMapper mapper) {
        this.tagService = tagService;
        this.mapper = mapper;
    }

    private TagResponse tagToTagResponse(Tag tag) {
        return mapper.convertValue(tag, TagResponse.class);
    }

    @Override
    public ResponseEntity<TagResponse> create(CreateTagRequest request) {
        Tag tag = mapper.convertValue(request, Tag.class);
        Tag createdTag = tagService.create(tag);

        TagResponse tagResponse = tagToTagResponse(createdTag);

        return ResponseEntity.status(HttpStatus.CREATED).body(tagResponse);
    }

    @Override
    public ResponseEntity<List<TagResponse>> searchAll() {
        List<Tag> tagList = tagService.searchAll();
        List<TagResponse> tagResponseList = tagList.stream()
                .map(tag -> new TagResponse(tag.getId(), tag.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(tagResponseList);
    }

    @Override
    public ResponseEntity<TagResponse> searchById(UUID id) {
        Tag tag = tagService.searchById(id);
        TagResponse tagResponse = tagToTagResponse(tag);

        if (tag != null) {
            return ResponseEntity.ok(tagResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<TagResponse> update(UUID id, @RequestBody Map<String, Object> params) {
        Tag tag = tagService.update(id, params);
        TagResponse tagResponse = tagToTagResponse(tag);

        if (tag != null) {
            return ResponseEntity.accepted().body(tagResponse);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Override
    public ResponseEntity<Void> delete(UUID id) {
        tagService.delete(id);
        return ResponseEntity.noContent().build();
    }

    @Override
    public ResponseEntity<List<TagResponse>> searchByName(@PathVariable String name) {
        List<Tag> tagList = tagService.searchByName(name);
        List<TagResponse> tagResponseList = tagList.stream()
                .map(tag -> new TagResponse(tag.getId(), tag.getName()))
                .collect(Collectors.toList());

        return ResponseEntity.ok(tagResponseList);
    }
}
