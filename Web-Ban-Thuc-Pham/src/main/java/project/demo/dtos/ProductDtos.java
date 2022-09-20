package project.demo.dtos;

public class ProductDtos {
	
	private Integer id;
		
	private Integer categoryId;
		
	private String title;
		
	private int price;
		
	private int discount;
		
	private String image;
		
	private String description;

	public ProductDtos(Integer id, Integer categoryId, String title, int price, int discount, String image,
			String description) {
		this.id = id;
		this.categoryId = categoryId;
		this.title = title;
		this.price = price;
		this.discount = discount;
		this.image = image;
		this.description = description;
	}

	public ProductDtos() {
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
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
	
	@Override
	public String toString() {
		return "ProductDtos [id=" + id + ", categoryId=" + categoryId + ", title=" + title + ", price=" + price
				+ ", discount=" + discount + ", image=" + image + ", description=" + description + "]";
	}

}
