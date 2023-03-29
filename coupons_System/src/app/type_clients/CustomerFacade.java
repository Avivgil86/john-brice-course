package app.type_clients;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Category;
import app_con.Coupon;

public class CustomerFacade extends ClientFacade {
	private int customerid;

	public CustomerFacade() {
	}

	public CustomerFacade(int customerid) {
		super();
		this.customerid = customerid;
	}

	@Override
	public boolean Login(String email, String password) throws CouponSystemExceptions {
		if (customersDao.isCustomerExists(email, password) == false) {
			throw new CouponSystemExceptions("email or password not valid");
		}
		this.customerid = customersDao.getOneCustomerByEmail(email).getId();
		return true;
	}

	public void purchaseCoupon(Coupon coupon) throws CouponSystemExceptions {
		if (coupon.getEndDate().isAfter(LocalDate.now())) {
			throw new CouponSystemExceptions("coupon date is expired");
		}
		if (coupon.getAmnout() <= 0) {
			throw new CouponSystemExceptions("coupon amount is 0 ");
		}
		if (couponsDao.isThisCouponsPurchaseByCustomerExesit(customerid, coupon.getId()) == true) {
			throw new CouponSystemExceptions("you cant purchase this coupon again ");
		}
		couponsDao.addCouponspurchase(coupon.getId(), customerid);
		coupon.setAmnout(coupon.getAmnout() - 1);
		couponsDao.updateCoupon(coupon);

	}

	public void getAllCouponsCustomer() throws CouponSystemExceptions {
		List<Coupon> customerCoupons = couponsDao.getCouponsBycustomer(customerid);
		for (Coupon coupon : customerCoupons) {
			System.out.println(coupon);
		}
	}

	public void getCustomerCouponsByCategory(Category category) throws CouponSystemExceptions {
		List<Coupon> coupons = couponsDao.getCouponsBycustomer(customerid);
		List<Coupon> couponsBycategory = new ArrayList<>();
		for (Coupon coupons2 : coupons) {
			if (coupons2.getCategory().equals(category)) {
				couponsBycategory.add(coupons2);
			}
		}
		for (Coupon coupon : couponsBycategory) {
			System.out.println(coupon);
		}
	}

	public void getCustomercouponsByprice(int amnout) throws CouponSystemExceptions {
		List<Coupon> coupons = couponsDao.getCouponsBycustomer(customerid);
		List<Coupon> couponsByPrice = new ArrayList<>();
		for (Coupon coupons2 : coupons) {
			if (coupons2.getPrice() <= amnout) {
				couponsByPrice.add(coupons2);
				System.out.println(couponsByPrice);
			}
		}
	}

	public void getCustomerDetails() throws CouponSystemExceptions {
		System.out.println(customersDao.getOneCustomerDetails(customerid));
	}
}
