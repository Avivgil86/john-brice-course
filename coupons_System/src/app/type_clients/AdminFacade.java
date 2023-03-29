package app.type_clients;

import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Company;
import app_con.Coupon;
import app_con.Customer;

public class AdminFacade extends ClientFacade {

	public AdminFacade() {
		super();
	}

	@Override
	public boolean Login(String email, String password) throws CouponSystemExceptions {
		if ((email.equalsIgnoreCase("admin@admin.com") && password.equals("admin")) == false) {
			throw new CouponSystemExceptions("admin email or password not valid");
		}
		return true;
	}

	public void addCompany(Company company) throws CouponSystemExceptions {
		if (companyDao.isCompanyExistsByEmail(company.getEmail())) {
			throw new CouponSystemExceptions("company with this email is already exists");
		}
		if (companyDao.isCompanyExistsByName(company.getName())) {
			throw new CouponSystemExceptions("company with this name is already exists");
		}
		companyDao.addCompany(company);
	}

	public void deleteComapny(int companyId) throws CouponSystemExceptions {
		if (companyDao.isCompanyExistsById(companyId) == false) {
			throw new CouponSystemExceptions("company with this id is not exists");
		}
		for (Coupon coupon : couponsDao.getCouponsByCompany(companyId)) {
			couponsDao.deletePurchaseCouponByCouponId(coupon.getId());
		}
		couponsDao.deleteCouponsBycompanyId(companyId);
		companyDao.deleteCompany(companyId);

	}

	public void updateComapny(Company company) throws CouponSystemExceptions {
		Company updatedCompany = companyDao.getOneCompany(company.getId());
		updatedCompany.setEmail(company.getEmail());
		updatedCompany.setPassword(company.getPassword());
		companyDao.updateCompany(updatedCompany);
	}

	public void getAllcompanies() throws CouponSystemExceptions {
		List<Company> companies = companyDao.getAllCompanies();
		for (Company company : companies) {
			System.out.println(company);
		}
	}

	public void getCompanyByid(int companyId) throws CouponSystemExceptions {
		Company company = companyDao.getOneCompany(companyId);
		System.out.println(company);
	}

	public void addNewCleint(Customer customer) throws CouponSystemExceptions {
		if (customersDao.isCustomerExistsByEmail(customer.getEmail()) == true) {
			throw new CouponSystemExceptions("Customer: this email already exist");
		} else {
			customersDao.addCustomer(customer);
		}
	}

	public void updateCustomer(Customer customer) throws CouponSystemExceptions {
		List<Customer> customers = customersDao.getAllCustomer();
		for (Customer customer2 : customers) {
			if (customer.getId() == customer2.getId()) {
				customersDao.updateCustomer(customer);
			}
		}
	}

	public void deleteCustomer(int customerid) throws CouponSystemExceptions {
		customersDao.deletePurchasesCustomer(customerid);
		customersDao.deleteCustomer(customerid);
	}

	public void getallCleint() throws CouponSystemExceptions {
		List<Customer> allcustomer = customersDao.getAllCustomer();
		for (Customer customer : allcustomer) {
			System.out.println(customer);
		}
	}

	public void getCustomerById(int customerid) throws CouponSystemExceptions {
		Customer customer = customersDao.getOneCustomer(customerid);
		System.out.println(customer);
	}
}
