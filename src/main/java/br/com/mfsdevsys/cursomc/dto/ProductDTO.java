package br.com.mfsdevsys.cursomc.dto;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

import br.com.mfsdevsys.cursomc.domain.Category;
import br.com.mfsdevsys.cursomc.domain.Product;

public class ProductDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	private String description;
	
	private Double salePrice;
	
	private String unitOfMeasure;
	
	private String imageUrl;
	
	private List<CategoryDTO> categories = new ArrayList<>();
	
	public ProductDTO() {
		
	}

	
	
	public ProductDTO(Long id, String name, String description, Double salePrice, String unitOfMeasure, String imageUrl) {
		this.id = id;
		this.name = name;
		this.description = description;
		this.salePrice = salePrice;
		this.unitOfMeasure = unitOfMeasure;
		this.imageUrl = imageUrl;
	}

	public ProductDTO( Product entity )
	{
		this.id = entity.getId();
		this.name = entity.getName();
		this.description= entity.getDescription();
		this.salePrice = entity.getSalePrice();
		this.unitOfMeasure= entity.getUnitOfMeasure();
		this.imageUrl= entity.getImageUrl();
	
	}

	public ProductDTO( Product entity, Set<Category> categories)
	{
		this(entity);
		categories.forEach(x -> this.categories.add(new CategoryDTO(x)));
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getDescription() {
		return description;
	}



	public void setDescription(String description) {
		this.description = description;
	}



	public Double getSalePrice() {
		return salePrice;
	}



	public void setSalePrice(Double salePrice) {
		this.salePrice = salePrice;
	}



	public String getUnitOfMeasure() {
		return unitOfMeasure;
	}



	public void setUnitOfMeasure(String unitOfMeasure) {
		this.unitOfMeasure = unitOfMeasure;
	}

	public String getImageUrl() {
		return imageUrl;
	}



	public void setImageUrl(String imageUrl) {
		this.imageUrl = imageUrl;
	}

	public List<CategoryDTO> getCategories() {
		return categories;
	}

	public void setCategories(List<CategoryDTO> categories) {
		this.categories = categories;
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
		ProductDTO other = (ProductDTO) obj;
		return Objects.equals(id, other.id);
	}

}
