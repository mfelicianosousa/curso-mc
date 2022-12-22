package br.com.mfsdevsys.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.cursomc.dto.CategoryDTO;
import br.com.mfsdevsys.cursomc.services.CategoryService;


@RestController
@RequestMapping(value="/categories")
public class CategoryResource {
	
	@Autowired
	private CategoryService service;
	
	
	@GetMapping
	public ResponseEntity<List<CategoryDTO>> findAll(){
		
		List<CategoryDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<CategoryDTO> findById(@PathVariable Integer id) {
		
		CategoryDTO dto = service.findById(id);
		
		return ResponseEntity.ok().body(dto);
		
	}
	

}
