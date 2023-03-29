package test;

import app.exxeptions.CouponSystemExceptions;
import app.type_clients.AdminFacade;
import app.type_clients.ClinetType;
import app.type_clients.LoginManager;
import app_con.Company;
import app_con.Customer;

public class AdminFacadeTest {
	private static AdminFacade adminFacade = null;

	public static void runAllAdminfacadeTest() {
		logInTest();
		addCompanyTest();
		deleteCompanyTest();
		updateCompanyTest();
		getAllCompaniesTest();
		getOneCompanyTest();
		addCustomerTest();
		updateCustomerTest();
		deleteCustomerTest();
		getAllCustomersTest();
		getOneCustomerTest();
	}

	public static void logInTest() {
		System.out.println("Admin login succeeded ");
		try {
			adminFacade = (AdminFacade) LoginManager.getInstance().logIn("admin@admin.com", "admin",
					ClinetType.ADMINISTRATOR);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void addCompanyTest() {
		System.out.println("Adding a company succeeded");
		try {
			Company company = new Company(0, "Nike", "nike@gmail.com", "1234");
			Company company1 = new Company(0, "Adidas", "adidas@gmail.com", "1234");
			Company company2 = new Company(0, "Sacuni", "sacuni@gmail.com", "1234");
			adminFacade.addCompany(company);
			adminFacade.addCompany(company1);
			adminFacade.addCompany(company2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void deleteCompanyTest() {
		System.out.println("The company was successfully deleted");
		try {
			adminFacade.deleteComapny(3);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}

	}

	public static void updateCompanyTest() {
		System.out.println("Company update successful");
		try {
			Company company2 = new Company(2, "Sacuni", "sacuni1234@gmail.com", "1234");
			adminFacade.updateComapny(company2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}

	}

	public static void getAllCompaniesTest() {
		System.out.println("Get all company succeeded:");
		try {
			adminFacade.getAllcompanies();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getOneCompanyTest() {
		System.out.println("Get one company succeeded:");
		try {
			adminFacade.getCompanyByid(2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void addCustomerTest() {
		System.out.println("Adding customer succeeded");
		try {
			Customer customer = new Customer(0, "aviv", "gil", "avivgil@gmail.com", "1234", null);
			Customer customer1 = new Customer(0, "lior", "levy", "liorlevy@gmail.com", "1234", null);
			Customer customer2 = new Customer(0, "asaf", "ron", "asafron@gmail.com", "1234", null);
			adminFacade.addNewCleint(customer);
			adminFacade.addNewCleint(customer1);
			adminFacade.addNewCleint(customer2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void updateCustomerTest() {
		System.out.println("Customer update successful");
		try {
			Customer customer2 = new Customer(2, "elad", "hook", "eladhook@gmail.com", "1234", null);
			adminFacade.updateCustomer(customer2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void deleteCustomerTest() {
		System.out.println("The customer was successfully deleted");
		try {
			adminFacade.deleteCustomer(3);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getAllCustomersTest() {
		System.out.println("Get all customers succeeded ");
		try {
			adminFacade.getallCleint();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}
	}

	public static void getOneCustomerTest() {
		System.out.println("Get one customer succeeded ");
		try {
			adminFacade.getCustomerById(2);
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}

	}
}
