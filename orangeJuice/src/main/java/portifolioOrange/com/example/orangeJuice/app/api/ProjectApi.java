package portifolioOrange.com.example.orangeJuice.app.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portifolioOrange.com.example.orangeJuice.app.api.dto.request.project.CreateProjectRequest;
import portifolioOrange.com.example.orangeJuice.app.api.dto.response.project.ProjectResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/projects")
@Tag(name = "Projetos")
@Schema(hidden = true)
public interface ProjectApi {

    @Operation(summary = "Create a new project", method = "POST")
    @PostMapping("criarProjeto")
    ResponseEntity<ProjectResponse> create(@RequestBody CreateProjectRequest request);

    @Operation(summary = "Search all Projects", method = "GET")
    @GetMapping("todos")
    ResponseEntity<List<ProjectResponse>> searchAll();

    @Operation(summary = "Search a projetc by id", method = "GET")
    @GetMapping("buscar/{id}")
    ResponseEntity<ProjectResponse> searchById(@PathVariable UUID id);


    @Operation(summary = "Update a project by id", method = "PATCH")
    @PatchMapping("atualizar/{id}")
    ResponseEntity<ProjectResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "Delete a project", method = "DELETE")
    @DeleteMapping("deletar/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

    @Operation(summary = "Search by tittle of project", method = "GET")
    @GetMapping("/buscarPorNome/{name}")
    ResponseEntity<List<ProjectResponse>> searchByName(@PathVariable String titleProject);

    @Operation(summary = "Search project by name", method = "GET")
    @GetMapping("/byTag/{tagName}")
    ResponseEntity<List<ProjectResponse>> getProjectsByTag(@PathVariable String tagName);


}
