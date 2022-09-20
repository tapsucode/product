package project.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "feedback")
public class Feedback {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "telephone")
	private String telephone;
	
	@Column(name = "subject")
	private String subject;
	
	@Column(name = "message")
	private String message;
	
	public Feedback(Integer id, String name, String email, String telephone, String subject, String mesage) {
		this.id = id;
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.subject = subject;
		this.message = mesage;
	}

	public Feedback() {
	}

	public Feedback(String name, String email, String telephone, String subject, String mesage) {
		this.name = name;
		this.email = email;
		this.telephone = telephone;
		this.subject = subject;
		this.message = mesage;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelephone() {
		return telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}

	public String getMessage() {
		return message;
	}

	public void setMesage(String message) {
		this.message = message;
	}
	
	
	
}
