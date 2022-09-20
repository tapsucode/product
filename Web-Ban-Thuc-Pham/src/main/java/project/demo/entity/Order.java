package project.demo.entity;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name = "order")
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private Integer id;
	
	@Column(name = "fullname")
	private String fullName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_number")
	private String phone_number;
	
	@Column(name = "address")
	private String address;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "order_date")
	@Temporal(TemporalType.DATE)
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	private Date order_date;
	
	@Column(name = "status")
	private boolean status;
	
	@Column(name = "total_money")
	private int total_money;
	
	@OneToOne(mappedBy = "order",cascade = CascadeType.ALL)
	private Order_details details;
	
	public Order(String fullName, String email, String phone_number, String address, String note, Date order_date,
			boolean status, int total_money, Order_details details) {
		this.fullName = fullName;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.note = note;
		this.order_date = order_date;
		this.status = status;
		this.total_money = total_money;
		this.details = details;
	}

	public Order() {
	}

	public Order(Integer id, String fullName, String email, String phone_number, String address, String note,
			Date order_date, boolean status, int total_money, Order_details details) {
		this.id = id;
		this.fullName = fullName;
		this.email = email;
		this.phone_number = phone_number;
		this.address = address;
		this.note = note;
		this.order_date = order_date;
		this.status = status;
		this.total_money = total_money;
		this.details = details;
	}

	public int getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public Date getOrder_date() {
		return order_date;
	}

	public void setOrder_date(Date order_date) {
		this.order_date = order_date;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public int getTotal_money() {
		return total_money;
	}

	public void setTotal_money(int total_money) {
		this.total_money = total_money;
	}

	public Order_details getDetails() {
		return details;
	}

	public void setDetails(Order_details details) {
		this.details = details;
	}
	
	
}