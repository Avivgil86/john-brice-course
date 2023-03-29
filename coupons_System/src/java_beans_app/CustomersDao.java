package java_beans_app;

import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Customer;

public interface CustomersDao {
	boolean isCustomerExists(String email, String password) throws CouponSystemExceptions;

	void addCustomer(Customer customer) throws CouponSystemExceptions;

	Customer getOneCustomerByEmail(String email) throws CouponSystemExceptions;

	void deleteCustomer(int CustomerId) throws CouponSystemExceptions;

	List<Customer> getAllCustomer() throws CouponSystemExceptions;

	Customer getOneCustomer(int CustomerId) throws CouponSystemExceptions;

	void updateCustomer(Customer customer) throws CouponSystemExceptions;

	void deletePurchasesCustomer(int CustomerId) throws CouponSystemExceptions;

	boolean isCustomerExistsByEmail(String email) throws CouponSystemExceptions;

	Customer getOneCustomerDetails(int custometid) throws CouponSystemExceptions;

}
