package java_beans_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Customer;
import app_connect.ConnectionPool;

public class CustomersDbDao implements CustomersDao {
	private ConnectionPool connection = ConnectionPool.getInstance();

	@Override
	public boolean isCustomerExists(String email, String password) throws CouponSystemExceptions {
		String sql = "select * from `customers` where email = ? and password = ?";
		Connection con = connection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			if (statement.execute()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" customer search fail " + e);
		} finally {
			connection.restoreConnection(con);

		}
		return false;
	}

	@Override
	public boolean isCustomerExistsByEmail(String email) throws CouponSystemExceptions {
		String sql = "select * from `customers` where email = ?";
		Connection con = connection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();

			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" customer search fail " + e);
		} finally {
			connection.restoreConnection(con);

		}
		return false;
	}

	@Override
	public void addCustomer(Customer customer) throws CouponSystemExceptions {
		String sql = "insert into `customers` (id,email,password,last_name,first_name) values (0,?,?,?,?)";
		Connection con = connection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, customer.getEmail());
			statement.setString(2, customer.getPassword());
			statement.setString(3, customer.getLastName());
			statement.setString(4, customer.getFirstName());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("added customer fail" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	@Override
	public void updateCustomer(Customer customer) throws CouponSystemExceptions {
		String sql = "update `customers` set email = ?, password = ? ,last_name = ? , first_name = ?  where id = ?;";
		Connection con = connection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, customer.getEmail());
			statement.setString(2, customer.getPassword());
			statement.setString(3, customer.getLastName());
			statement.setString(4, customer.getFirstName());
			statement.setInt(5, customer.getId());
			statement.executeUpdate();

		} catch (SQLException e) {
			throw new CouponSystemExceptions("Update customer fail " + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public void deletePurchasesCustomer(int CustomerId) throws CouponSystemExceptions {
		String sql = "delete from coupons_vs_customers where customer_id =?";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CustomerId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("delete purchase customer fail" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	public void deleteCustomer(int CustomerId) throws CouponSystemExceptions {
		String sql = "delete from customers where id =?";
		Connection con = connection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CustomerId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("delete customer fail" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public List<Customer> getAllCustomer() throws CouponSystemExceptions {
		List<Customer> customers = new ArrayList<>();
		String sql = "select * from customers";
		Connection con = connection.getConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setLastName(rs.getString("last_name"));
				customer.setFirstName(rs.getString("first_name"));
				customers.add(customer);
			}
			return customers;
		} catch (SQLException e) {
			throw new CouponSystemExceptions("get all customers fail" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public Customer getOneCustomer(int CustomerId) throws CouponSystemExceptions {
		String sql = "select * from `customers` where id = ?";
		Customer customer = new Customer();
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CustomerId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setLastName(rs.getString("last_name"));
				customer.setFirstName(rs.getString("first_name"));
			}
			return customer;
		} catch (SQLException e) {
			throw new CouponSystemExceptions("get one customer fail" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public Customer getOneCustomerByEmail(String email) throws CouponSystemExceptions {
		String sql = " select * from customers where email = ? ";
		Customer customer = null;
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));
				customer.setFirstName(rs.getString("last_name"));
				customer.setLastName(rs.getString("first_name"));
			}
		} catch (SQLException e) {
			throw new CouponSystemExceptions(" get one customer by email fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return customer;
	}

	@Override
	public Customer getOneCustomerDetails(int custometid) throws CouponSystemExceptions {
		String sql = "select * from `customers` where id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, custometid);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer.setId(rs.getInt("id"));
				customer.setLastName(rs.getString("last_name"));
				customer.setFirstName(rs.getString("first_name"));
				customer.setEmail(rs.getString("email"));
				customer.setPassword(rs.getString("password"));

				return customer;
			}
		} catch (SQLException e) {
			throw new CouponSystemExceptions(" company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return null;
	}

}
