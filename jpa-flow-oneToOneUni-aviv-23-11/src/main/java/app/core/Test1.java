package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.Company;

//@Component
public class Test1 implements CommandLineRunner {
	@Autowired
	private EntityManagerFactory managerFactory;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Test 1");

		EntityManager em = managerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			Address address = new Address(0, "Israel", "Tel Aviv", "Alenbi", 0);
			Company company = new Company(0, "Osem", address);
			company.setAddress(address);
			//save comapny
			em.persist(company);
			//end the transaction
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
