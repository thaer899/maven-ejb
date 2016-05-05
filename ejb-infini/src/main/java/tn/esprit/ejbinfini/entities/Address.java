package tn.esprit.ejbinfini.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

/**
 * 
 * The <b>"@Embeddable"</b> annotation specifies a class whose instances are stored as a part
 * of an owning entity and share the identity of the entity. No need to declare
 * an id into an embeddable class. Each of the persistent properties or fields
 * of the embedded object is mapped to the database table for the entity. Note
 * that the Transient annotation may be used to designate the non-persistent
 * state of an embeddable class.
 * <p>
 * 
 * @author Amine Bessrour
 *
 */

@Embeddable
public class Address implements Serializable {

	private String street;
	private String city;
	private Integer zipCode;
	private String country;

	public Address() {
		super();
	}

	public Address(String street, String city, Integer zipCode, String country) {
		super();
		this.street = street;
		this.city = city;
		this.zipCode = zipCode;
		this.country = country;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Integer getZipCode() {
		return zipCode;
	}

	public void setZipCode(Integer zipCode) {
		this.zipCode = zipCode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	private static final long serialVersionUID = 1L;

}
