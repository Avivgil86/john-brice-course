package app.type_clients;

import app.exxeptions.CouponSystemExceptions;
import java_beans_app.CompanyDao;
import java_beans_app.CompanyDbDao;
import java_beans_app.CouponDbDao;
import java_beans_app.CouponsDao;
import java_beans_app.CustomersDao;
import java_beans_app.CustomersDbDao;

public abstract class ClientFacade {
	protected CompanyDao companyDao = new CompanyDbDao();
	protected CustomersDao customersDao = new CustomersDbDao();
	protected CouponsDao couponsDao = new CouponDbDao();

	public abstract boolean Login(String email, String password) throws CouponSystemExceptions;

}
