package com.sri.prac.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.Id;

@Entity
//model and its fields with their respective validation constraints
public class Address {
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO,generator="native")
	@GenericGenerator(name = "native",strategy = "native")
	private Long id;
	
	@NotNull(message = " detailedAddress cannot be empty")
	private String detailedAddress;
	@NotNull(message = " city cannot be empty")
	private String city;
	@NotNull(message = " state cannot be empty")
	private String state;
	@NotNull(message = " pinCode cannot be empty")
	private String pinCode;
	
	@OneToOne(mappedBy = "address")					//mapping to center
	private Center center;
	
	//Getters and Setters
	public Address() {
		
	}
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getDetailedAddress() {
		return detailedAddress;
	}
	public void setDetailedAddress(String detailedAddress) {
		this.detailedAddress = detailedAddress;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getPinCode() {
		return pinCode;
	}
	public void setPinCode(String pinCode) {
		this.pinCode = pinCode;
	}
	
	public Address(String detailedAddress, String city, String state, String pinCode, Center center) {
		super();

		this.detailedAddress = detailedAddress;
		this.city = city;
		this.state = state;
		this.pinCode = pinCode;
		this.center = center;
	}
	
	
}
