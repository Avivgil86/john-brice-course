package app.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import app.core.entities.Address;
import app.core.entities.Company;

@Component
public class Test2 implements CommandLineRunner {
	@Autowired
	private EntityManagerFactory managerFactory;

	@Override
	public void run(String... args) throws Exception {
		System.out.println("============== Test 2");

		EntityManager em = managerFactory.createEntityManager();
		try {
			em.getTransaction().begin();
			// get a company or address (and its address)
			Address address = em.find(Address.class, 1);
			System.out.println(address);
			if (address != null) {
				System.out.println(address.getCompany());

			}
			// delete the company and address
			// em.remove(company);
			em.getTransaction().commit();
		} catch (Exception e) {
			e.printStackTrace();
			em.getTransaction().rollback();
		}
	}

}
