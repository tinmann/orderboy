package com.starter.orderBoy.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.Valid;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name="ADDRESS")

public class AddressPojo {
	
	
	 @Valid
	 @Id
	 @Column(name="ADDRESS_ID")
	 @GeneratedValue(generator="gen")
	 @GenericGenerator(name="gen", strategy="foreign",parameters=@Parameter(name="property", value="userDetailsPojo"))
	private long addressId;
	
	@Valid
	@Column(name="STATE")
	private String state;
	

	@Column(name="COUNTRY")
	private String country;
	
	@Valid
	@Column(name="CITY")
	private String city;
	
	@Valid
	@Column(name="AREA")
	private String area;
	
	@Valid
	@Column(name="PINCODE")
	private int pinCode;
	
	@OneToOne
    @PrimaryKeyJoinColumn
    private UserDetailsPojo userDetailsPojo;

	public long getAddressId() {
		return addressId;
	}

	public void setAddressId(long addressId) {
		this.addressId = addressId;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getArea() {
		return area;
	}

	public void setArea(String area) {
		this.area = area;
	}

	public int getPinCode() {
		return pinCode;
	}

	public void setPinCode(int pinCode) {
		this.pinCode = pinCode;
	}

	public UserDetailsPojo getUserDetailsPojo() {
		return userDetailsPojo;
	}

	public void setUserDetailsPojo(UserDetailsPojo userDetailsPojo) {
		this.userDetailsPojo = userDetailsPojo;
	}
	
	

}
