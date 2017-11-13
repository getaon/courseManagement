package entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Instructor {

	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)

	private int id;
	private String firstname;
	private String lastname;
	private String email;
	private String phone;
	@ManyToOne
	@JoinColumn(name="user")
	private User user;
	private boolean isactive;
	
	
	public Instructor() {
		// TODO Auto-generated constructor stub
	}
	
	public Instructor(String firstname, String lastname, String email, String phone, User user) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.phone=phone;
		this.user=user;
	}
	public Instructor(String firstname, String lastname, String email, String phone, User user, boolean isactive) {
		this.firstname=firstname;
		this.lastname=lastname;
		this.email=email;
		this.phone=phone;
		this.user=user;
		this.isactive=isactive;
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}
	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isIsactive() {
		return isactive;
	}
	public void setIsactive(boolean isactive) {
		this.isactive = isactive;
	}
	
	
	
}
