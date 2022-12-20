package br.com.mfsdevsys.cursomc.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.mfsdevsys.cursomc.domain.Categoria;
import br.com.mfsdevsys.cursomc.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository repositoryCategoria;
		
	public Categoria findById(Integer id) {
		
		Optional<Categoria> obj = repositoryCategoria.findById(id);
		
		return obj.orElse(null);
	}

}
