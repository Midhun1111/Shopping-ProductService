package com.shopping.ProductService.model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;    
    @Column(name="productname")
    private String productname;
    @Column(name="price")
    private double price;
    @Column(name="description")
    private String description;
    @Column(name="imageurl")
    private String imageurl;
    @Column(name="productstock")
    private int productstock;
	public Product(Long id, String productname, double price, String description, String imageurl, int productstock) {
		super();
		this.id = id;
		this.productname = productname;
		this.price = price;
		this.description = description;
		this.imageurl = imageurl;
		this.productstock = productstock;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getProductname() {
		return productname;
	}
	public void setProductname(String productname) {
		this.productname = productname;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getImageurl() {
		return imageurl;
	}
	public void setImageurl(String imageurl) {
		this.imageurl = imageurl;
	}
	public int getProductstock() {
		return productstock;
	}
	public void setProductstock(int productstock) {
		this.productstock = productstock;
	}
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}

 
}
