package app_connect;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import app.exxeptions.CouponSystemExceptions;

public class ConnectionPool {
	private Set<Connection> connect = new HashSet<>();
	private static final int MAX = 5;
	private String urlDB = "jdbc:mysql://localhost:3306/couponsfactory4?createDatabaseIfNotExist=true";
	private String passwordDB = "1234";
	private String UserDB = "root";
	private static ConnectionPool instance = new ConnectionPool();

	private ConnectionPool() {
		try {
			init();
		} catch (CouponSystemExceptions e) {
			e.printStackTrace();
		}

	}

	public static ConnectionPool getInstance() {
		return instance;
	}

	public synchronized void init() throws CouponSystemExceptions {
		for (int i = 0; i < MAX; i++) {
			try {
				Connection con = DriverManager.getConnection(urlDB, UserDB, passwordDB);
				this.connect.add(con);
			} catch (SQLException e) {
				throw new CouponSystemExceptions("init connection pool failed", e);
			}
		}
	}

	public synchronized Connection getConnection() throws CouponSystemExceptions {
		while (connect.isEmpty()) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Iterator<Connection> it = connect.iterator();
		Connection con = it.next();
		it.remove();
		return con;
	}

	public synchronized void restoreConnection(Connection connection) throws CouponSystemExceptions {
		connect.add(connection);
		notifyAll();
	}

	public synchronized void closeAll() throws CouponSystemExceptions {
		try {
			while (connect.size() < MAX) {
				wait();
			}

		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		try {
			for (Connection connection : connect) {
				connection.close();
			}
		} catch (SQLException e) {
			throw new CouponSystemExceptions("close connection");
		}

	}

}
