package portifolioOrange.com.example.orangeJuice.app.api;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portifolioOrange.com.example.orangeJuice.app.api.dto.request.tag.CreateTagRequest;
import portifolioOrange.com.example.orangeJuice.app.api.dto.response.tag.TagResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/tags")
@Tag(name = "Tags")
public interface TagApi {

    @Operation(summary = "Cria uma tag", method = "POST")
    @PostMapping("/criarTag")
    ResponseEntity<TagResponse> create(@RequestBody CreateTagRequest request);

    @Operation(summary = "Busca todas as tags", method = "GET")
    @GetMapping("/todas")
    ResponseEntity<List<TagResponse>> searchAll();

    @Operation(summary = "Busca uma tag por id", method = "GET")
    @GetMapping("/buscar/{id}")
    ResponseEntity<TagResponse> searchById(@PathVariable UUID id);

    @Operation(summary = "Atualiza uma tag por id", method = "PATCH")
    @PatchMapping("/atualizar/{id}")
    ResponseEntity<TagResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "Deleta uma tag", method = "DELETE")
    @DeleteMapping("/deletar/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

    @Operation(summary = "Busca tags pelo nome", method = "GET")
    @GetMapping("/buscarPorNome/{name}")
    ResponseEntity<List<TagResponse>> searchByName(@PathVariable String name);

}
