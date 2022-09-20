package project.demo.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "order_details")

public class Order_details {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "id")
	private Order order;
	
	@OneToMany (mappedBy = "details",cascade = CascadeType.ALL)
	private Set<Product> products;
	
	@Column(name = "price")
	private int price;
	
	@Column(name = "num")
	private int num;
	
	@Column(name = "total_money")
	private int total_money;
	
	
	public Order_details(Order order, Set<Product> products, int price, int num, int total_money) {
		this.order = order;
		this.products = products;
		this.price = price;
		this.num = num;
		this.total_money = total_money;
	}

	public Order_details() {
	}

	public Order_details(Integer id, Order order, Set<Product> products, int price, int num, int total_money) {
		this.id = id;
		this.order = order;
		this.products = products;
		this.price = price;
		this.num = num;
		this.total_money = total_money;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}
	
	
}
