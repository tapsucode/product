package project.demo.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "product")

public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name = "category_id" )
	private Category category;
	
	@Column(name = "title")
	private String title;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "discount")
	private int discount;
	
	@Column(name = "image")
	private String image;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "created_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date created_at;
	
	@Column(name = "update_at")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date update_at;
	
	@Column(name ="deleted")
	private boolean deleted;
	
	@ManyToOne
	@JoinColumn(name = "details_id")
	private Order_details details;
	
	public Product() {
	}
	

	public Product(Integer id, Category category, String title, int price, int discount, String image, String description,
			Date created_at, Date update_at, boolean deleted, Order_details details) {
		this.id = id;
		this.category = category;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.image = image;
		this.description = description;
		this.created_at = created_at;
		this.update_at = update_at;
		this.deleted = deleted;
		this.details = details;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

	public Date getUpdate_at() {
		return update_at;
	}

	public void setUpdate_at(Date update_at) {
		this.update_at = update_at;
	}

	public boolean isDeleted() {
		return deleted;
	}

	public void setDeleted(boolean deleted) {
		this.deleted = deleted;
	}

	public Order_details getDetails() {
		return details;
	}

	public void setDetails(Order_details details) {
		this.details = details;
	}
	
	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", title=" + title + ", price=" + price + ", discount="
				+ discount + ", image=" + image + ", description=" + description + ", created_at=" + created_at
				+ ", update_at=" + update_at + ", deleted=" + deleted + ", details=" + details + "]";
	}
}
