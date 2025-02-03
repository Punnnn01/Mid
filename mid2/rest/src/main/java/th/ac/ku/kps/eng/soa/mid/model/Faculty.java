package th.ac.ku.kps.eng.soa.mid.model;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Faculty implements Serializable {
	
	@JsonProperty("name")
	private String name;
	@JsonProperty("address")
	private String address;
	@JsonProperty("phoneNumber")
	private String[] phoneNumber;
	@JsonProperty("email")
	private String email;
	
	public Faculty(String name , String address , String[] phoneNumber , String email) {
		this.name = name;
		this.address = address;
		this.phoneNumber = phoneNumber;
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String[] getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String[] phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	
	

}
