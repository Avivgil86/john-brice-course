package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.Company;
import app.core.repos.Companyrepo;

@Component
public class Test3 implements CommandLineRunner {
	@Autowired
	private Companyrepo companyrepo;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Test 3");

		try {
			Company company = new Company(0, "Elite", null);
			Address address = new Address(0, "israel", "ramat gan", "hertzel", 0);
			company.setAddress(address);
			companyrepo.save(company);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
