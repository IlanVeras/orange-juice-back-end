package portifolioOrange.com.example.orangeJuice.domain.service;

import java.util.List;
import java.util.Map;
import java.util.UUID;

import portifolioOrange.com.example.orangeJuice.domain.entity.ImgProject;

public abstract class ImgProjectService {
	
	public abstract ImgProject searchById(UUID id);
    public abstract ImgProject create(ImgProject imgProject);
    public abstract ImgProject update(UUID id, Map<String, Object> params);

    public abstract void delete(UUID id);

}
