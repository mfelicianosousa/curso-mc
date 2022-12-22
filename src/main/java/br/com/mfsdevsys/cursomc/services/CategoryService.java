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

import br.com.mfsdevsys.cursomc.domain.Category;
import br.com.mfsdevsys.cursomc.dto.CategoryDTO;
import br.com.mfsdevsys.cursomc.repositories.CategoryRepository;
import br.com.mfsdevsys.cursomc.services.exceptions.DatabaseException;
import br.com.mfsdevsys.cursomc.services.exceptions.ResourceNotFoundException;

@Service
public class CategoryService {
	
	@Autowired
	private CategoryRepository repository;	
	
	@Transactional(readOnly=true)	
	public CategoryDTO findById(Integer id) {
		
		Optional<Category> obj = repository.findById(id);
		Category entity = obj.orElseThrow(()-> new ResourceNotFoundException("Entity not found"));
		
		return new CategoryDTO(entity);
	}
	
	@Transactional(readOnly=true)
	public Page<CategoryDTO> findAllPaged(PageRequest pageRequest){
		
		Page<Category> list = repository.findAll(pageRequest);
		return list.map(x -> new CategoryDTO(x));
		
	}

	@Transactional
	public CategoryDTO insert(CategoryDTO dto) {
		Category entity = new Category();
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
	}

	@Transactional
	public CategoryDTO update(Integer id, CategoryDTO dto) {
		try {
		Category entity = repository.getReferenceById(id);
		entity.setName(dto.getName());
		entity = repository.save(entity);
		return new CategoryDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		}

	}

	public void delete(Integer id) {
		try {
		repository.deleteById(id);
		} catch(EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found "+id);
		} catch(DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
