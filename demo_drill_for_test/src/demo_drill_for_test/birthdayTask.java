package demo_drill_for_test;

import java.time.LocalDate;
import java.util.Set;

public class birthdayTask implements Runnable {
	private Set<Person> pepole;

	public birthdayTask(Set<Person> pepole) {
		super();
		this.pepole = pepole;
	}

	@Override
	public void run() {
		while (true) {
			for (Person person : pepole) {
				if (person.getBirthday().isEqual(LocalDate.now())) {
					System.out.println("Happy Birthday " + person.getName());

				}
			}

			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
