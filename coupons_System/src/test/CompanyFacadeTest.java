package test;

import java.time.LocalDate;

import app.exxeptions.CouponSystemExceptions;
import app.type_clients.ClinetType;
import app.type_clients.CompanyFacade;
import app.type_clients.LoginManager;
import app_con.Category;
import app_con.Coupon;

public class CompanyFacadeTest {
	private static CompanyFacade companyFacade = null;

	public static void runAllCompanyfacadeTest() {
		logInTest();
		addNewCoupon();
		updateCoupon();
		deleteCoupon();
		getAllCouponsByCompany();
		getAllCouponsCompanyByCategory();
		getAllCouponsCompanyByPrice();
		getCompanyDetails();

	}

	public static void logInTest() {
		System.out.println("Company login succeeded");
		try {
			companyFacade = (CompanyFacade) LoginManager.getInstance().logIn("nike@gmail.com", "1234",
					ClinetType.COMPANY);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();

		}
	}

	public static void addNewCoupon() {
		System.out.println("Adding a coupon succeeded");
		try {
			Coupon coupon = new Coupon(0, 1, "marvel", "book", LocalDate.of(2022, 11, 27), LocalDate.of(2022, 11, 30),
					100, 50, "dog", Category.FOOD);
			Coupon coupon1 = new Coupon(0, 2, "disny", "book", LocalDate.of(2022, 11, 27), LocalDate.of(2022, 11, 30),
					100, 50, "cat", Category.ELECTRICITY);
			Coupon coupon2 = new Coupon(0, 1, "DC", "book", LocalDate.of(2022, 11, 27), LocalDate.of(2022, 11, 30),
					100, 50, "Spider", Category.VACETION);
			companyFacade.addNewCoupon(coupon);
			companyFacade.addNewCoupon(coupon1);
			companyFacade.addNewCoupon(coupon2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void updateCoupon() {
		System.out.println("Coupon update successful");
		try {
			Coupon coupon2 = new Coupon(1, 2, "Moses", "dinner", LocalDate.of(2022, 11, 27),
					LocalDate.of(2022, 11, 29), 100, 50, "Spider", Category.FOOD);
			companyFacade.CompanyUpdateCoupon(coupon2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void deleteCoupon() {
		System.out.println("The coupon was successfully deleted");
		try {
			companyFacade.companyDeleteCoupon(3);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCouponsByCompany() {
		System.out.println("Get all coupons by company Succeeded:");
		try {
			companyFacade.getCompanyCoupons();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCouponsCompanyByCategory() {
		System.out.println("Get all coupon by category succeeded:");
		try {
			companyFacade.getCompanyCouponsByCategory(Category.FOOD);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}

	}

	public static void getAllCouponsCompanyByPrice() {
		System.out.println("Get all coupon by price succeeded:");
		try {
			companyFacade.getCompanycouponsByprice(50);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getCompanyDetails() {
		System.out.println("Get company details succeeded:");
		try {
			companyFacade.getCompanyDetails();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}
}
