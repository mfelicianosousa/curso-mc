package br.com.mfsdevsys.cursomc.services;

import java.util.List;
import java.util.Locale.Category;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.mfsdevsys.cursomc.domain.Categoria;
import br.com.mfsdevsys.cursomc.dto.CategoriaDTO;
import br.com.mfsdevsys.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repository;
		
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = repository.findById(id);
		
		return obj.orElse(null);
	}
	
	@Transactional(readOnly=true)
	public List<CategoriaDTO> findAll(){
		
		List<Categoria> list = repository.findAll();
		
		return list.stream().map(x -> new CategoriaDTO(x)).collect(Collectors.toList());
		
	}
}
