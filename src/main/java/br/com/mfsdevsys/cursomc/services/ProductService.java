package br.com.mfsdevsys.cursomc.services;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mfsdevsys.cursomc.domain.Category;
import br.com.mfsdevsys.cursomc.domain.Product;
import br.com.mfsdevsys.cursomc.dto.CategoryDTO;
import br.com.mfsdevsys.cursomc.dto.ProductDTO;
import br.com.mfsdevsys.cursomc.repositories.ProductRepository;
import br.com.mfsdevsys.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
		
	@Transactional(readOnly=true)	
	public ProductDTO findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		
		return new ProductDTO(entity);
	}
	
	@Transactional(readOnly=true)
	public List<ProductDTO> findAll(){
		
		List<Product> list = repository.findAll();
		
		return list.stream().map(x -> new ProductDTO(x)).collect(Collectors.toList());
		
	}
	
	@Transactional
	public ProductDTO insert(@RequestBody ProductDTO dto){
		Product entity = new Product();
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSalePrice(dto.getSalePrice());
		entity.setUnitOfMeasure(dto.getUnitOfMeasure());
		
		for (CategoryDTO cat: dto.getCategories()) {
			Category category = new Category();
			category.setId(cat.getId());
			entity.getCategories().add(category);
		}
		entity = repository.save(entity) ;
		return new ProductDTO(entity);
	}
}
