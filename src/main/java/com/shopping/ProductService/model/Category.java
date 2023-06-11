package com.shopping.ProductService.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="category")
public class Category {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	@Column(name="categoryName")
	private String categoryName;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}
	public Category(Long id, String categoryName) {
		super();
		this.id = id;
		this.categoryName = categoryName;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}



}
