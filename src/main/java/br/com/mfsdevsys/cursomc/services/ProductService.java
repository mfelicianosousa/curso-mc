package br.com.mfsdevsys.cursomc.services;

import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;

import br.com.mfsdevsys.cursomc.domain.Category;
import br.com.mfsdevsys.cursomc.domain.Product;
import br.com.mfsdevsys.cursomc.dto.CategoryDTO;
import br.com.mfsdevsys.cursomc.dto.ProductDTO;
import br.com.mfsdevsys.cursomc.repositories.CategoryRepository;
import br.com.mfsdevsys.cursomc.repositories.ProductRepository;
import br.com.mfsdevsys.cursomc.services.exceptions.DatabaseException;
import br.com.mfsdevsys.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class ProductService {
	
	@Autowired
	private ProductRepository repository;
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Transactional(readOnly=true)
	public Page<ProductDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Product> list = repository.findAll(pageRequest);
		return list.map(x -> new ProductDTO(x));
		
	}
	
		
	@Transactional(readOnly=true)	
	public ProductDTO findById(Long id) {
		
		Optional<Product> obj = repository.findById(id);
		Product entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		
		return new ProductDTO(entity, entity.getCategories());
	}
	
	@Transactional
	public ProductDTO insert(@RequestBody ProductDTO dto){
		Product entity = new Product();
		copyDtoToEntity(dto, entity);
		entity = repository.save(entity) ;
		return new ProductDTO(entity);
	}
	
	
	@Transactional
	public ProductDTO update(Long id, ProductDTO dto) {
		try {
			Product entity = repository.getReferenceById(id);
			copyDtoToEntity(dto, entity);
			entity = repository.save(entity);
			return new ProductDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}

	}

	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
	
	private void copyDtoToEntity(ProductDTO dto, Product entity) {
		entity.setName(dto.getName());
		entity.setDescription(dto.getDescription());
		entity.setSalePrice(dto.getSalePrice());
		entity.setUnitOfMeasure(dto.getUnitOfMeasure());
		entity.setImageUrl(dto.getImageUrl());
		
		entity.getCategories().clear();
		for (CategoryDTO categoryDTO: dto.getCategories()) {
			Category category = categoryRepository.getOne(categoryDTO.getId()) ;
			entity.getCategories().add(category);
		}
	}
	
}
