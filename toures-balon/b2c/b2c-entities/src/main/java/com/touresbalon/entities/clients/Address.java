package com.touresbalon.entities.clients;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.touresbalon.enums.AddressType;

@Entity
@Table(name = "b2c_address")
public class Address implements Serializable {

	/**
	 * serialVersionUID
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name = "ad_id")
	private Long id;
	@Column(name = "ad_street")
	private String street;
	@Column(name = "ad_state")
	private String state;
	@Column(name = "ad_zip_code")
	private String zipCode;
	@Column(name = "ad_country")
	private String country;
	@Column(name = "ad_address_type")
	private AddressType addresType;
	@Column(name = "ad_city")
	private String city;
	@ManyToOne(cascade= CascadeType.ALL)
	@JoinColumn(name = "cad_client_id",foreignKey=@ForeignKey(name = "FK_Address_clientId_Client_id"))
	@JsonIgnore
	private Client client;

	public AddressType getAddresType() {
		return addresType;
	}

	public void setAddresType(AddressType addresType) {
		this.addresType = addresType;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client clients) {
		this.client = clients;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipCode() {
		return zipCode;
	}

	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
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
}
