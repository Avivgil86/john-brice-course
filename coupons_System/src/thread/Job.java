package thread;

import java.util.List;
import java.util.concurrent.TimeUnit;

import app.exxeptions.CouponSystemExceptions;
import app_con.Coupon;
import java_beans_app.CouponDbDao;

public class Job implements Runnable {

	private CouponDbDao couponDbDao;

	public Job() {
		this.couponDbDao = new CouponDbDao();
	}

	@Override
	public void run() {
		while (true) {
			try {
				if (couponDbDao.getAllCouponsThatExpired() != null) {
					List<Coupon> couponExpired = couponDbDao.getAllCouponsThatExpired();
					for (Coupon coupon : couponExpired) {
						couponDbDao.deletePurchaseCouponByCouponId(coupon.getId());
						couponDbDao.deleteCoupon(coupon.getId());
					}
				}
				TimeUnit.DAYS.sleep(1);
			} catch (CouponSystemExceptions | InterruptedException e) {
				System.out.println("PROGRAM EXIT ");
				break;

			}
		}

	}

}
