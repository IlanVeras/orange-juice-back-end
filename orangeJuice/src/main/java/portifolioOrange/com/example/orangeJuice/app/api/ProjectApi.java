package portifolioOrange.com.example.orangeJuice.app.api;

import io.swagger.v3.oas.annotations.Operation;
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
public interface ProjectApi {

    @Operation(summary = "Cria um projeto", method = "POST")
    @PostMapping("criarProjeto")
    ResponseEntity<ProjectResponse> create(@RequestBody CreateProjectRequest request);

    @Operation(summary = "Busca todos os projetos", method = "GET")
    @GetMapping("todos")
    ResponseEntity<List<ProjectResponse>> searchAll();

    @Operation(summary = "Busca um projeto por id", method = "GET")
    @GetMapping("buscar/{id}")
    ResponseEntity<ProjectResponse> searchById(@PathVariable UUID id);


    @Operation(summary = "Atualiza um projeto por id", method = "PATCH")
    @PatchMapping("atualizar/{id}")
    ResponseEntity<ProjectResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "deleta um projeto", method = "DELETE")
    @DeleteMapping("deletar/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

    @Operation(summary = "Buscar pelo Titutlo do projeto", method = "GET")
    @GetMapping("/buscarPorNome/{name}")
    ResponseEntity<List<ProjectResponse>> searchByName(@PathVariable String titleProject);


}
