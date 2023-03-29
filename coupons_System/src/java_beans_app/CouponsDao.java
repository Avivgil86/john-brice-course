package java_beans_app;

import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Category;
import app_con.Coupon;

public interface CouponsDao {
	void addCouponspurchase(int CouponId, int CustomerId) throws CouponSystemExceptions;

	void addCoupon(Coupon coupon) throws CouponSystemExceptions;

	void deleteCoupon(int CouponId) throws CouponSystemExceptions;

	List<Coupon> getAllCoupons() throws CouponSystemExceptions;

	Coupon getOneCoupon(int CouponId) throws CouponSystemExceptions;

	void updateCoupon(Coupon coupon) throws CouponSystemExceptions;

	void deleteCouponsBycompanyId(int companyId) throws CouponSystemExceptions;

	void deletePurchaseCouponByCouponId(int couponId) throws CouponSystemExceptions;

	List<Coupon> getCouponsByCompany(int companyId) throws CouponSystemExceptions;

	boolean isCouponExistsByTitle(String title) throws CouponSystemExceptions;

	List<Coupon> getCouponsBycustomer(int customerId) throws CouponSystemExceptions;

	List<Coupon> getCompanyCouponsByCategory(int companyId, Category category) throws CouponSystemExceptions;

	List<Coupon> getAllCouponsThatExpired() throws CouponSystemExceptions;

	List<Coupon> getCompanyCouponsByPrice(int companyId, double price) throws CouponSystemExceptions;

	boolean isThisCouponsPurchaseByCustomerExesit(int customerid, int couponid) throws CouponSystemExceptions;

}
