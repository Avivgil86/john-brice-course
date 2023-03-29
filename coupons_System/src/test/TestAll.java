package test;

import app.exxeptions.CouponSystemExceptions;
import app_connect.ConnectionPool;
import thread.Job;

public class TestAll {
	public static void runAllTest() {
		Job job = new Job();
		Thread thread = new Thread(job);
		thread.setDaemon(true);
		thread.start();
		try {
			ConnectionPool.getInstance().init();
			System.out.println("Test started");
			System.out.println("Admin test ============================================================");
			AdminFacadeTest.runAllAdminfacadeTest();
			System.out.println("Company test ==========================================================");
			CompanyFacadeTest.runAllCompanyfacadeTest();
			System.out.println("Customer test =========================================================");
			CustomerFacadeTest.runAllCustomerfacadeTest();
		} catch (CouponSystemExceptions e1) {
			e1.getMessage();

		} finally {
			System.out.println("Test ended");
			thread.interrupt();
		}
	}
}
