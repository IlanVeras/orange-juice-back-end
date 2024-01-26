package portifolioOrange.com.example.orangeJuice.app;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portifolioOrange.com.example.orangeJuice.app.dto.request.user.CreateUserRequest;
import portifolioOrange.com.example.orangeJuice.app.dto.response.user.UserResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/users")
@Tag(name = "Usuarios")
public interface UserApi {

    @Operation(summary = "Cria um usuário", method = "POST")
    @PostMapping("criarUsuario")
    ResponseEntity<UserResponse> create(@RequestBody CreateUserRequest request);

    @Operation(summary = "Busca todos os usuários", method = "GET")
    @GetMapping("todos")
    ResponseEntity<List<UserResponse>> searchAll();

    @Operation(summary = "Busca um usuário por id", method = "GET")
    @GetMapping("buscar/{id}")
    ResponseEntity<UserResponse> searchById(@PathVariable UUID id);


    @Operation(summary = "Atualiza um usuário por id", method = "PATCH")
    @PatchMapping("atualizar/{id}")
    ResponseEntity<UserResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "deleta um usuário", method = "DELETE")
    @DeleteMapping("deletar/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

    ResponseEntity<List<UserResponse>> searchByName(@PathVariable String name);
}
