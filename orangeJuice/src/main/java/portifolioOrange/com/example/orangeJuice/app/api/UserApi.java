package portifolioOrange.com.example.orangeJuice.app.api;

import io.swagger.v3.oas.annotations.Hidden;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import portifolioOrange.com.example.orangeJuice.app.api.dto.request.user.CreateUserRequest;
import portifolioOrange.com.example.orangeJuice.app.api.dto.response.user.UserResponse;

import java.util.List;
import java.util.Map;
import java.util.UUID;

@RequestMapping("/v1/users")
@Tag(name = "Usuarios")
@Schema(hidden = true)
public interface UserApi {


    @Operation(summary = "Search all the users", method = "GET")
    @GetMapping("todos")
    ResponseEntity<List<UserResponse>> searchAll();

    @Operation(summary = "Search an user by id", method = "GET")
    @GetMapping("buscar/{id}")
    ResponseEntity<UserResponse> searchById(@PathVariable UUID id);


    @Operation(summary = "Search an user by id", method = "PATCH")
    @PatchMapping("atualizar/{id}")
    ResponseEntity<UserResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

    @Operation(summary = "Delete an user.", method = "DELETE")
    @DeleteMapping("deletar/{id}")
    ResponseEntity<Void> delete(@PathVariable UUID id);

    @Operation(summary = "Search by user name.", method = "GET")
    @GetMapping("/buscarPorNome/{name}")
    ResponseEntity<List<UserResponse>> searchByName(@PathVariable String name);


}
