package app_con;

import java.util.ArrayList;

public class Company {
	private int id;
	private String name;
	private String email;
	private String password;
	private ArrayList<Coupon> coupons;
	public Company() {
		
	}
	public Company(int id,String name, String email, String password) {
		super();
		this.id =id;
		this.name = name;
		this.email = email;
		this.password = password;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ArrayList<Coupon> getCoupons() {
		return coupons;
	}

	public void setCoupon(ArrayList<Coupon> coupons) {
		this.coupons = coupons;
	}

	@Override
	public String toString() {
		return "Company:  id - " + id + ", name - " + name + ", email - " + email + ", password - " + password;
	}

}
