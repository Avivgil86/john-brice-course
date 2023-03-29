package java_beans_app;

import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Company;
import app_con.Coupon;

public interface CompanyDao {
	boolean isCompanyExists(String email, String password) throws CouponSystemExceptions;

	void addCompany(Company company) throws CouponSystemExceptions;

	void updateCompany(Company company) throws CouponSystemExceptions;

	void deleteCompany(int companyId) throws CouponSystemExceptions;

	List<Company> getAllCompanies() throws CouponSystemExceptions;

	Company getOneCompany(int companyId) throws CouponSystemExceptions;

	Company getOneCompanyByEmail(String email) throws CouponSystemExceptions;

	boolean isCompanyExistsByEmail(String email) throws CouponSystemExceptions;

	boolean isCompanyExistsByName(String name) throws CouponSystemExceptions;

	boolean isCompanyExistsById(int companyid) throws CouponSystemExceptions;

	List<Coupon> getCompanyCouponsByid(int companyid) throws CouponSystemExceptions;

	Company getOneCompanyDetails(int companyId) throws CouponSystemExceptions;

}
