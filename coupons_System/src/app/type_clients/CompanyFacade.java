package app.type_clients;

import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Category;
import app_con.Company;
import app_con.Coupon;

public class CompanyFacade extends ClientFacade {
	private int comapnyid;

	public CompanyFacade(int comapnyid) {
		super();
		this.comapnyid = comapnyid;
	}

	public CompanyFacade() {
	}

	@Override
	public boolean Login(String email, String password) throws CouponSystemExceptions {
		if (companyDao.isCompanyExists(email, password) == false) {
			throw new CouponSystemExceptions("company email or password not valid");
		}
		this.comapnyid = companyDao.getOneCompanyByEmail(email).getId();
		return true;
	}

	public void addNewCoupon(Coupon coupon) throws CouponSystemExceptions {
		if (couponsDao.isCouponExistsByTitle(coupon.getTitle())) {
			throw new CouponSystemExceptions("coupon with this title is already exists");

		}
		couponsDao.addCoupon(coupon);
	}

	public void CompanyUpdateCoupon(Coupon coupon) throws CouponSystemExceptions {
		couponsDao.updateCoupon(coupon);
	}

	public void companyDeleteCoupon(int couponID) throws CouponSystemExceptions {
		couponsDao.deleteCoupon(couponID);
	}

	public void getCompanyCoupons() throws CouponSystemExceptions {
		List<Coupon> coupons = couponsDao.getCouponsByCompany(comapnyid);
		for (Coupon coupon : coupons) {
			System.out.println(coupon);
		}
	}

	public void getCompanyCouponsByCategory(Category category) throws CouponSystemExceptions {
		List<Coupon> couponsByCategory = couponsDao.getCompanyCouponsByCategory(comapnyid, category);
		for (Coupon coupon : couponsByCategory) {
			System.out.println(coupon);
		}
	}

	public void getCompanycouponsByprice(int amnout) throws CouponSystemExceptions {
		List<Coupon> couponsByPrice = couponsDao.getCompanyCouponsByPrice(comapnyid, amnout);
		for (Coupon coupons2 : couponsByPrice) {
			System.out.println(coupons2);
		}
	}

	public void getCompanyDetails() throws CouponSystemExceptions {
		Company companyDetails = companyDao.getOneCompanyDetails(comapnyid);
		System.out.println(companyDetails);
	}
}
