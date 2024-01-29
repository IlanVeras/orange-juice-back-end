package portifolioOrange.com.example.orangeJuice.app;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import portifolioOrange.com.example.orangeJuice.app.dto.request.imgproject.CreateImgProjectRequest;
import portifolioOrange.com.example.orangeJuice.app.dto.response.imgproject.ImgProjectResponse;


	@RequestMapping("/v1/project/images")
	@Tag(name = "Imagens")
	public interface ImgProjectApi {

	    @Operation(summary = "Cria uma imagem", method = "POST")
	    @PostMapping("criarImagem")
	    ResponseEntity<ImgProjectResponse> create(@RequestBody CreateImgProjectRequest request);

	    
	    @Operation(summary = "Busca uma imagem id", method = "GET")
	    @GetMapping("buscar/{id}")
	    ResponseEntity<ImgProjectResponse> searchById(@PathVariable UUID id);


	    @Operation(summary = "Atualiza uma imagem por id", method = "PATCH")
	    @PatchMapping("atualizar/{id}")
	    ResponseEntity<ImgProjectResponse> update(@PathVariable UUID id, @RequestBody Map<String, Object> params);

	    @Operation(summary = "deleta uma imagem", method = "DELETE")
	    @DeleteMapping("deletar/{id}")
	    ResponseEntity<Void> delete(@PathVariable UUID id);
	
}
