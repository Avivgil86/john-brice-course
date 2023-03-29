package app.type_clients;

import app.exxeptions.CouponSystemExceptions;

public class LoginManager {
	private static LoginManager instance = null;

	private LoginManager() {
	}

	public static LoginManager getInstance() {
		if (instance == null) {
			instance = new LoginManager();
		}
		return instance;
	}

	public synchronized ClientFacade logIn(String email, String password, ClinetType clinetType)
			throws CouponSystemExceptions {
		switch (clinetType) {
		case ADMINISTRATOR: {
			AdminFacade adminFacade = new AdminFacade();
			if (adminFacade.Login(email, password)) {

				return adminFacade;
			}
		}
		case COMPANY: {
			CompanyFacade companyFacade = new CompanyFacade();
			if (companyFacade.Login(email, password)) {

				return companyFacade;
			}
		}
		case CUSTOMER: {
			CustomerFacade customerFacade = new CustomerFacade();
			if (customerFacade.Login(email, password)) {
				return customerFacade;
			}
		}
			return null;
		}

		throw new CouponSystemExceptions("Login manager fail ");

	}
}
