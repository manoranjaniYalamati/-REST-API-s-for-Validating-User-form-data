package com.sri.prac.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.Valid;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.annotations.GenericGenerator;

import com.sri.prac.Convertor.StringListConverter;

import javax.persistence.Id;

@Entity
public class Center {																		//model and its fields with their respective validation constraints
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private long id;

	@NotNull(message = " Center Name cannot be empty")
	@Size(max= 40,message="Center Name must be less than 40 charcters")
	private String centerName;
	
	@NotNull(message = " Center code cannot be empty")
	@Size(min=12,max= 12,message="Center code must be exactly 12 characters")
	@Pattern(regexp = "[A-Za-z0-9]+$",message="Center code must be alpha numeric")											
	private String centerCode;
	
	@OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "addressId", referencedColumnName = "id")							//one to one mapping for address 
	@Valid @NotNull(message = " Address cannot be empty")						
	private Address address;
	
	private int studentCapacity;
	@Convert(converter = StringListConverter.class)
	private List<String> coursesOffered;
	private long createdOn;
	
	@Email(message="Email should be valid")
	private String contactEmail;
	
	@NotNull(message="Contact number cannot be empty")
	@Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$",message="Phone number should be valid")	
	private String contactPhone;
	
	//Getters and Setters 
	public long getCreatedOn() {
		return createdOn;
	}
	public void setCreatedOn(long createdOn) {
		this.createdOn = createdOn;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactPhone() {
		return contactPhone;
	}
	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}
	public String getCenterName() {
		return centerName;
	}
	public void setCenterName(String centerName) {
		System.out.println("executing set");
		this.centerName = centerName;
	}
	public String getCenterCode() {
		return centerCode;
	}
	public void setCenterCode(String centerCode) {
		this.centerCode = centerCode;
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	public int getStudentCapacity() {
		return studentCapacity;
	}
	public void setStudentCapacity(int studentCapacity) {
		this.studentCapacity = studentCapacity;
	}
	public List<String> getCoursesOffered() {
		return coursesOffered;
	}
	public void setCoursesOffered(List<String> coursesOffered) {
		this.coursesOffered = coursesOffered;
	}
	public Center(
			@NotNull(message = " Center Name cannot be null") @Size(max = 40, message = "Center Name must be less than 40 charcters") String centerName,
			@NotNull(message = " Center code cannot be null") @Size(min = 12, max = 40, message = "Center code must be exactly 12 characters") @Pattern(regexp = "[A-Za-z0-9]+$") String centerCode,
			@NotNull(message = " Center Name cannot be null") Address address, int studentCapacity,
			List<String> coursesOffered, long createdOn, @Email(message = "Email should be valid") String contactEmail,
			@NotNull(message = "Contact number cannot be null") @Pattern(regexp = "^\\s*(?:\\+?(\\d{1,3}))?[-. (]*(\\d{3})[-. )]*(\\d{3})[-. ]*(\\d{4})(?: *x(\\d+))?\\s*$") String contactPhone) {
		super();
	
		this.centerName = centerName;
		this.centerCode = centerCode;
		this.address = address;
		this.studentCapacity = studentCapacity;
		this.coursesOffered = coursesOffered;
		this.createdOn = createdOn;
		this.contactEmail = contactEmail;
		this.contactPhone = contactPhone;
	}
	public Center() {
		
	}
	
	
	
	
	
	
}
