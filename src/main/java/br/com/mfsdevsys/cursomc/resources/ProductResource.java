package br.com.mfsdevsys.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.cursomc.domain.Category;
import br.com.mfsdevsys.cursomc.domain.Product;
import br.com.mfsdevsys.cursomc.dto.CategoryDTO;
import br.com.mfsdevsys.cursomc.dto.ProductDTO;
import br.com.mfsdevsys.cursomc.services.ProductService;


@RestController
@RequestMapping(value="/products")
public class ProductResource {
	
	@Autowired
	private ProductService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<ProductDTO> findById(@PathVariable Long id) {
		
		ProductDTO dto = service.findById(id);
		
		return ResponseEntity.ok(dto);
		
	}
	
	@GetMapping
	public ResponseEntity<List<ProductDTO>> findAll(){
		
		List<ProductDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	
	@PostMapping
	public ResponseEntity<ProductDTO> insert(@RequestBody ProductDTO obj) {
		obj = service.insert(obj);
		return ResponseEntity.ok(obj);
	}
	

}
