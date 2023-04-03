package app.core.entities;

import java.util.Objects;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Address {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String cuntry;
	private String city;
	private String street;
	private int apt;
	// inverse of this mapping (mappedBy)
	@OneToOne(mappedBy = "address")
	private Company company;

	public Address(int id, String cuntry, String city, String street, int apt) {
		super();
		this.id = id;
		this.cuntry = cuntry;
		this.city = city;
		this.street = street;
		this.apt = apt;
	}

	public Address() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCuntry() {
		return cuntry;
	}

	public void setCuntry(String cuntry) {
		this.cuntry = cuntry;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getApt() {
		return apt;
	}

	public void setApt(int apt) {
		this.apt = apt;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Address other = (Address) obj;
		return id == other.id;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", cuntry=" + cuntry + ", city=" + city + ", street=" + street + ", apt=" + apt
				+ "]";
	}

}