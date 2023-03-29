package java_beans_app;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import app.exxeptions.CouponSystemExceptions;
import app_con.Category;
import app_con.Coupon;
import app_connect.ConnectionPool;

public class CouponDbDao implements CouponsDao {
	private ConnectionPool connection = ConnectionPool.getInstance();


	@Override
	public void addCouponspurchase(int CouponId, int CustomerId) throws CouponSystemExceptions {
		String sql = "insert into `coupons_vs_customers`(customer_id,coupon_id) values( ? , ?);";
		Connection con = connection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, CustomerId);
			pstmt.setInt(2, CouponId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("purchase coupon fail" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	@Override
	public void addCoupon(Coupon coupon) throws CouponSystemExceptions {
		String sql = "insert into `coupons` (title,description,start_date,end_date,amnout,price,image,company_id,category) values(? , ? , ? , ? , ? ,?,?, ?, ?)";
		Connection con = connection.getConnection();
		System.out.println(coupon);
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, coupon.getTitle());
			statement.setString(2, coupon.getDescription());
			statement.setDate(3, Date.valueOf(coupon.getStartDate()));
			statement.setDate(4, Date.valueOf(coupon.getEndDate()));
			statement.setInt(5, coupon.getAmnout());
			statement.setDouble(6, coupon.getPrice());
			statement.setString(7, coupon.getImage());
			statement.setInt(8, coupon.getCompanyId());
			statement.setString(9, coupon.getCategory().name());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("add coupon fail" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public void updateCoupon(Coupon coupon) throws CouponSystemExceptions {
		String sql = "update `coupons` set title = ?,description = ?,start_date = ?,end_date = ?,amnout = ?,price = ?,image = ? , category = ? where id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, coupon.getTitle());
			statement.setString(2, coupon.getDescription());
			statement.setDate(3, Date.valueOf(coupon.getStartDate()));
			statement.setDate(4, Date.valueOf(coupon.getEndDate()));
			statement.setInt(5, coupon.getAmnout());
			statement.setDouble(6, coupon.getPrice());
			statement.setString(7, coupon.getImage());
			statement.setString(8, coupon.getCategory().name());
			statement.setInt(9, coupon.getId());
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("Update coupon fail " + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public void deleteCoupon(int CouponId) throws CouponSystemExceptions {
		String sql = "delete from `coupons` where id = ?";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, CouponId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("delete coupon fail" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public List<Coupon> getAllCoupons() throws CouponSystemExceptions {
		List<Coupon> coupons = new ArrayList<>();
		String sql = "select * from companies;";
		Connection con = connection.getConnection();
		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			while (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setTitle(rs.getNString("title"));
				coupon.setDescription(rs.getString("description"));
				coupon.setStartDate(rs.getDate("start_date").toLocalDate());
				coupon.setEndDate(rs.getDate("end_date").toLocalDate());
				coupon.setAmnout(rs.getInt("amount"));
				coupon.setPrice(rs.getDouble("price"));
				coupon.setImage(rs.getString("image"));
				coupon.setCategory(Category.valueOf(rs.getString("category")));
				coupons.add(coupon);
			}
			return coupons;

		} catch (SQLException e) {
			throw new CouponSystemExceptions("failed to get all coupons" + e);
		} finally {
			connection.restoreConnection(con);

		}

	}

	@Override
	public Coupon getOneCoupon(int CouponId) throws CouponSystemExceptions {
		Coupon coupon = null;
		List<Coupon> coupons = getAllCoupons();
		for (Coupon coupon1 : coupons) {
			if (coupon1.getId() == CouponId) {
				coupon = coupon1;
			}
		}
		return coupon;

	}

	@Override
	public void deleteCouponsBycompanyId(int companyId) throws CouponSystemExceptions {
		String sql = "delete from `coupons` where company_id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			statement.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("delete coupon fail" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	@Override
	public void deletePurchaseCouponByCouponId(int couponId) throws CouponSystemExceptions {
		String sql = "delete from `coupons_vs_customers` where coupon_id = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, couponId);
			pstmt.executeUpdate();
		} catch (SQLException e) {
			throw new CouponSystemExceptions("SQL: delete purchase fail" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	@Override
	public List<Coupon> getCouponsByCompany(int companyId) throws CouponSystemExceptions {
		List<Coupon> coupons = new ArrayList<>();
		String sql = "select * from `coupons` where company_id = ?";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			ResultSet rs = statement.executeQuery();
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

		} catch (SQLException e) {
			throw new CouponSystemExceptions("SQL: failed to get all coupons\n" + e);
		} finally {
			connection.restoreConnection(con);

		}
		return coupons;
	}

	@Override
	public boolean isCouponExistsByTitle(String title) throws CouponSystemExceptions {
		String sql = "select * from `coupons` where title = ?;";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setString(1, title);
			ResultSet rs = statement.executeQuery();
			if (rs.next()) {
				return true;
			}

		} catch (SQLException e) {
			throw new CouponSystemExceptions(" coupon search fail " + e);
		} finally {
			connection.restoreConnection(con);
		}
		return false;
	}

	@Override
	public List<Coupon> getCouponsBycustomer(int customerId) throws CouponSystemExceptions {
		String sql = "select * from coupons where id in(select coupon_id from coupons_vs_customers where customer_id = ?)";
		Connection con = connection.getConnection();
		try {
			List<Coupon> coupons = new ArrayList<>();
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerId);
			ResultSet rs = statement.executeQuery();
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
				coupon.setCategory(Category.valueOf(rs.getString("category")));
				coupons.add(coupon);
			}
			return coupons;

		} catch (SQLException e) {
			throw new CouponSystemExceptions("SQL: failed to get all coupons\n" + e);
		} finally {
			connection.restoreConnection(con);

		}
	}

	@Override
	public List<Coupon> getCompanyCouponsByCategory(int companyId, Category category) throws CouponSystemExceptions {
		List<Coupon> coupons = new ArrayList<>();
		String sql = "select * from `coupons` where company_id = ? and category = ?";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			statement.setString(2, category.name());
			ResultSet rs = statement.executeQuery();
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

		} catch (SQLException e) {
			throw new CouponSystemExceptions("SQL: failed to get all coupons\n" + e);
		} finally {
			connection.restoreConnection(con);

		}
		return coupons;
	}

	@Override
	public List<Coupon> getAllCouponsThatExpired() throws CouponSystemExceptions {
		String sql = "select * from coupons where end_date < now()";
		List<Coupon> coupons = new ArrayList<>();
		Connection con = connection.getConnection();

		try {
			Statement statement = con.createStatement();
			ResultSet rs = statement.executeQuery(sql);
			if (rs.next()) {
				Coupon coupon = new Coupon();
				coupon.setId(rs.getInt("id"));
				coupon.setTitle(rs.getString("title"));
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
			throw new CouponSystemExceptions("SQL: failed to get all coupons that expired" + e);
		} finally {
		connection.restoreConnection(con);

		}

	}

	@Override
	public List<Coupon> getCompanyCouponsByPrice(int companyId, double price) throws CouponSystemExceptions {
		List<Coupon> coupons = new ArrayList<>();
		String sql = "select * from `coupons` where company_id = ? and price = ?";
		Connection con = connection.getConnection();
		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, companyId);
			statement.setDouble(2, price);
			ResultSet rs = statement.executeQuery();
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

		} catch (SQLException e) {
			throw new CouponSystemExceptions("SQL: failed to get all coupons\n" + e);
		} finally {
			connection.restoreConnection(con);

		}
		return coupons;
	}

	@Override
	public boolean isThisCouponsPurchaseByCustomerExesit(int customerid, int couponid) throws CouponSystemExceptions {
		String sql = "select * from `coupons_vs_customers` where customer_id and coupon_id= ?";
		Connection con = connection.getConnection();

		try {
			PreparedStatement statement = con.prepareStatement(sql);
			statement.setInt(1, customerid);
			statement.setInt(1, couponid);
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

}
