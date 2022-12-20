package br.com.mfsdevsys.cursomc.resources;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.mfsdevsys.cursomc.domain.Categoria;
import br.com.mfsdevsys.cursomc.dto.CategoriaDTO;
import br.com.mfsdevsys.cursomc.services.CategoriaService;


@RestController
@RequestMapping(value="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService service;
	
	@RequestMapping(value="/{id}", method=RequestMethod.GET)
	public ResponseEntity<?> findById(@PathVariable Integer id) {
		
		Categoria obj = service.findById(id);
		
		return ResponseEntity.ok().body(obj);
		
	}
	
	@GetMapping
	public ResponseEntity<List<CategoriaDTO>> findAll(){
		
		List<CategoriaDTO> list = service.findAll();
		
		return ResponseEntity.ok().body(list);
		
	}
	

}
