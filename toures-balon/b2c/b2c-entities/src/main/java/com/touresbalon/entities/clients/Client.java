package com.touresbalon.entities.clients;

import java.io.Serializable;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.touresbalon.common.utils.EncryptDeserializer;
import com.touresbalon.enums.ClientStatus;
import com.touresbalon.enums.CreditCardType;

@Entity
@Table(name = "b2c_client")
public class Client implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "cl_id")
	private Long id;
	@Column(name = "cl_names", length = 50)
	private String names;
	@Column(name = "cl_lastnames", length = 50)
	private String lastNames;
	@Column(name = "cl_phone_number", length = 10)
	private String phoneNumber;
	@Column(name = "cl_email", length = 50)
	private String email;
	@Column(name = "cl_credit_card_type")
	@Enumerated(EnumType.STRING)
	private CreditCardType creditCardType;
	@Column(name = "cl_credit_card_number")
	@JsonDeserialize(using=EncryptDeserializer.class)
	private String creditCardNumber;
	@Column(name = "status")
	@Enumerated(EnumType.STRING)
	private ClientStatus status;
	@ManyToMany(mappedBy = "clients",fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	private List<Address> addresses;
	@Column(name = "cl_password")	
	@JsonDeserialize(using=EncryptDeserializer.class)	
	private String password;

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Address> getAddresses() {
		return addresses;
	}

	public void setAddresses(List<Address> addresses) {
		this.addresses = addresses;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNames() {
		return names;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public String getLastNames() {
		return lastNames;
	}

	public void setLastNames(String lastNames) {
		this.lastNames = lastNames;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public CreditCardType getCreditCardType() {
		return creditCardType;
	}

	public void setCreditCardType(CreditCardType creditCardType) {
		this.creditCardType = creditCardType;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public ClientStatus getStatus() {
		return status;
	}

	public void setStatus(ClientStatus status) {
		this.status = status;
	}

}
