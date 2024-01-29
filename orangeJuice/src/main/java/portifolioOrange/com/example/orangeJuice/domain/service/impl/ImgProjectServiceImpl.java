package portifolioOrange.com.example.orangeJuice.domain.service.impl;

import java.util.Map;
import java.util.UUID;

import portifolioOrange.com.example.orangeJuice.domain.entity.ImgProject;
import portifolioOrange.com.example.orangeJuice.domain.entity.Project;
import portifolioOrange.com.example.orangeJuice.domain.exception.ImgProjectNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.exception.ProjectNotFoundException;
import portifolioOrange.com.example.orangeJuice.domain.repository.ImgProjectRepository;

public class ImgProjectServiceImpl {

	private ImgProjectRepository imgProjectRepository;
	
	
	public ImgProjectServiceImpl(ImgProjectRepository imgProjectRepository) {
        this.imgProjectRepository = imgProjectRepository;
    }
	
	public ImgProject searchById(UUID id) {
        return imgProjectRepository.findById(id).orElseThrow();

    }
	
	public ImgProject create(ImgProject imgProject) {
        return imgProjectRepository.save(imgProject);
    }
	
	
	@Override
    public ImgProject update(UUID id, Map<String, Object> params) {
        ImgProject imgProjectToUpdate = imgProjectRepository.findById(id).orElseThrow();

       
        imgProjectToUpdate.setLink(params.getOrDefault("link", imgProjectToUpdate.getLink()).toString());
        
        return imgProjectRepository.save(imgProjectToUpdate);
    }
	
	@Override
    public void delete(UUID id) {
		imgProjectRepository.findById(id).ifPresent(imgProjectRepository::delete);
    }

}
