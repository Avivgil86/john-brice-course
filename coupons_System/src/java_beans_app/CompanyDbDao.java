package java_beans_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Category;
import app_con.Company;
import app_con.Coupon;
import app_connect.ConnectionPool;

public class CompanyDbDao implements CompanyDao {
	private ConnectionPool connection = ConnectionPool.getInstance();

	@Override
	public boolean isCompanyExists(String email, String password) throws CouponSystemExceptions {
		String sql = "select * from `companies` where email = ? and password = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			statement.setString(2, password);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" Company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return false;
	}

	@Override
	public void addCompany(Company company) throws CouponSystemExceptions {
		String sql = "insert into `companies`(id,name,email,password) values( ? , ? , ? , ? );";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			statement.setInt(1, company.getId());
			statement.setString(2, company.getName());
			statement.setString(3, company.getEmail());
			statement.setString(4, company.getPassword());
			statement.executeUpdate();
			ResultSet IDkey = statement.getGeneratedKeys();
			IDkey.next();
			int id = IDkey.getInt(1);
			company.setId(id);
		} catch (SQLException e) {
			throw new CouponSystemExceptions("add company fail" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	@Override
	public void updateCompany(Company company) throws CouponSystemExceptions {
		String sql = "update `companies` set name = ?, email = ?, password = ?  where id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, company.getName());
			statement.setString(2, company.getEmail());
			statement.setString(3, company.getPassword());
			statement.setInt(4, company.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("Update company fail " + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public void deleteCompany(int companyId) throws CouponSystemExceptions {
		String sql = "delete from companies where id = ?;";
		Connection con = connection.getConnection();
		try {

			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("delete company fail" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public List<Company> getAllCompanies() throws CouponSystemExceptions {
		List<Company> companies = new ArrayList<>();
		String sql = "select * from companies;";
		Connection con = connection.getConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getNString("email"));
				company.setPassword(rs.getString("password"));
				companies.add(company);
			}
			return companies;

		} catch (SQLException e) {
			throw new CouponSystemExceptions("Fail to get all companies" + e.getMessage());
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public boolean isCompanyExistsByEmail(String email) throws CouponSystemExceptions {
		String sql = "select * from `companies` where email = ?";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" Company search fail" + e);
		} finally {
			connection.restoreConnection(con);
		}
		return false;
	}

	@Override
	public boolean isCompanyExistsByName(String name) throws CouponSystemExceptions {
		String sql = "select * from `companies` where name = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, name);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" Company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return false;
	}

	@Override
	public boolean isCompanyExistsById(int companyid) throws CouponSystemExceptions {
		String sql = "select * from `companies` where id =?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyid);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" Company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return false;
	}

	@Override
	public Company getOneCompanyByEmail(String email) throws CouponSystemExceptions {
		String sql = "select * from `companies` where email =?;";
		Company company = null;
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, email);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setPassword(rs.getString("password"));
				company.setEmail(rs.getNString("email"));
			}
		} catch (SQLException e) {
			throw new CouponSystemExceptions("Company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return company;
	}

	@Override
	public List<Coupon> getCompanyCouponsByid(int companyid) throws CouponSystemExceptions {
		String sql = " select * from `coupons` where company_id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyid);
			ResultSet rs = statement.executeQuery();
			List<Coupon> coupons = new ArrayList<>();
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setTitle(rs.getNString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmnout(rs.getInt("amnout"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
				coupon.setCompanyId(rs.getInt("company_id"));
				coupon.setCategory(Category.valueOf(rs.getString("category")));
				coupons.add(coupon);

			}
			return coupons;
		} catch (SQLException e) {
			throw new CouponSystemExceptions(" coupons search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
	}

	@Override
	public Company getOneCompany(int companyId) throws CouponSystemExceptions {
		String sql = "select * from `companies` where id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getNString("email"));
				company.setPassword(rs.getNString("password"));

				return company;
			}
		} catch (SQLException e) {
			throw new CouponSystemExceptions(" company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return null;
	}

	@Override
	public Company getOneCompanyDetails(int companyId) throws CouponSystemExceptions {
		String sql = "select * from `companies` where id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			ResultSet rs = statement.executeQuery();
			while (rs.next()) {
				Company company = new Company();
				company.setId(rs.getInt("id"));
				company.setName(rs.getString("name"));
				company.setEmail(rs.getString("email"));
				company.setPassword(rs.getString("password"));

				return company;
			}
		} catch (SQLException e) {
			throw new CouponSystemExceptions(" company search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return null;
	}
}
