package test;

import java.time.LocalDate;

import app.exxeptions.CouponSystemExceptions;
import app.type_clients.ClinetType;
import app.type_clients.CustomerFacade;
import app.type_clients.LoginManager;
import app_con.Category;
import app_con.Coupon;

public class CustomerFacadeTest {
	private static CustomerFacade customerFacade = null;

	public static void runAllCustomerfacadeTest() {
		logInTest();
		purchaseCouponTest();
		getAllCouponsByCustomerTest();
		getAllCustomerCouponsByCategoryTest();
		getAllCustomerCouponsByPriceTest();
		getAllCustomerDetails();

	}

	public static void logInTest() {
		System.out.println("Customer login succeeded");
		try {
			customerFacade = (CustomerFacade) LoginManager.getInstance().logIn("avivgil@gmail.com", "1234",
					ClinetType.CUSTOMER);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void purchaseCouponTest() {
		System.out.println("Purchase coupon succeeded");

		Coupon coupon = new Coupon(1, 2, "marvel", "book", LocalDate.of(2022, 11, 27), LocalDate.of(2022, 11, 28),
				100, 50, "dog", Category.FOOD);
		try {
			customerFacade.purchaseCoupon(coupon);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCouponsByCustomerTest() {
		System.out.println("Get all coupons succeeded");
		try {
			customerFacade.getAllCouponsCustomer();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCustomerCouponsByCategoryTest() {
		System.out.println("Get all coupons by category succeeded");
		try {
			customerFacade.getCustomerCouponsByCategory(Category.FOOD);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCustomerCouponsByPriceTest() {
		System.out.println("Get all coupons by price succeeded");
		try {
			customerFacade.getCustomercouponsByprice(60);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCustomerDetails() {
		System.out.println("Get customer details succeeded");
		try {
			customerFacade.getCustomerDetails();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}
}
