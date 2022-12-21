package br.com.mfsdevsys.cursomc.domain;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name="produto")
public class Produto implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(nullable=false, length=60)
	private String nome;
	
	@Column(nullable=true)
	private String descricao;
	
	private Double preco;
	
	@Column(nullable=false, length=3)
	private String unidade;
	
	@Column(nullable=true, length=100)
	private String imageUrl;
	
	@ManyToMany
	@JoinTable(name="produto_categoria",
	   joinColumns=@JoinColumn(name="produto_id"),
	   inverseJoinColumns=@JoinColumn(name="categoria_id")
	)
	private List<Categoria> categorias = new ArrayList<>();
	
	public Produto() {
		
	}

	public Produto(Long id, String nome,String descricao,Double preco, String imageUrl, String unidade) {
		this.id = id;
		this.nome = nome;
		this.descricao=descricao;
		this.preco = preco;
		this.unidade= unidade;
		this.imageUrl=imageUrl;
		
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Double getPreco() {
		return preco;
	}

	public void setPreco(Double preco) {
		this.preco = preco;
	}
	
	

	
	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String unidade) {
		this.unidade = unidade;
	}

	public String getImageUrl() {
		return imageUrl;
	}

	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

	public void setCategorias(List<Categoria> categorias) {
		this.categorias = categorias;
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
