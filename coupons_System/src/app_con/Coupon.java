package app_con;

import java.time.LocalDate;

public class Coupon {
	private int id;
	private int companyId;
	private String title;
	private String description;
	private LocalDate startDate;
	private LocalDate endDate;
	private int amnout;
	private double price;
	private String image;
	private Category category;

	public Coupon() {

	}

	public Coupon(int id,int companyId,String title, String description, LocalDate startDate, LocalDate endDate,
			int amnout, double price, String image, Category category) {
		super();
		this.id = id;
		this.companyId = companyId;
		this.title = title;
		this.description = description;
		this.startDate = startDate;
		this.endDate = endDate;
		this.amnout = amnout;
		this.price = price;
		this.image = image;
		this.category = category;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCompanyId() {
		return companyId;
	}

	public void setCompanyId(int companyId) {
		this.companyId = companyId;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getStartDate() {
		return startDate;
	}

	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}

	public LocalDate getEndDate() {
		return endDate;
	}

	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}

	public int getAmnout() {
		return amnout;
	}

	public void setAmnout(int amnout) {
		this.amnout = amnout;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	@Override
	public String toString() {
		return "Coupons: id - " + id + ", company id - " + companyId + ", title - " + title + ", description - " + description
				+ ", start date - " + startDate + ", end date - " + endDate + ", amount - " + amnout + ", price - " + price
				+ ", image - " + image + ", category - " + category;
	}

}
