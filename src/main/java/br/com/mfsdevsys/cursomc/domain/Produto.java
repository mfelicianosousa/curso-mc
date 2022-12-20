package br.com.mfsdevsys.cursomc.domain;

import java.io.Serializable;
import java.util.Objects;

public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	public Produto() {
		
	}

	public Produto(Integer id, String nome) {
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		return Objects.equals(id, other.id);
	}


}
