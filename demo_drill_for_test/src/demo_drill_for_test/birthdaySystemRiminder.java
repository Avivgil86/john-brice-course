package demo_drill_for_test;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

public class birthdaySystemRiminder {
	private Set<Person> pepole;
	private birthdayTask task;
	private static Scanner sc = new Scanner(System.in);

	public birthdaySystemRiminder() {
		super();
		this.pepole = new HashSet<Person>();
		this.task = new birthdayTask(pepole);
		Thread t1 = new Thread(task);
		t1.setDaemon(true);
		t1.start();
	}

	public birthdaySystemRiminder(Set<Person> pepole, birthdayTask task) {
		super();
		this.pepole = pepole;
		this.task = task;
	}

	public void startSystem() {
		int choice = 0;
		while (choice != 4) {
			showMenu();

			choice = sc.nextInt();
			sc.nextLine();
			switch (choice) {
			case 1:
				System.out.println("please enter id");
				int id = sc.nextInt();
				sc.nextLine();
				System.out.println("please enter name");
				String name = sc.nextLine();
				System.out.println("please enter birthday(yyyy-mm-dd)");
				String date = sc.next();
				Person p1 = new Person(id, name, LocalDate.parse(date));
				addPerson(p1);
				sc.nextLine();
				break;

			case 2:
				System.out.println("please enter the peapole id");
				int personToRemove = sc.nextInt();
				sc.nextLine();

				deletePerson(personToRemove);
				break;
			case 3:
				List<Person> sortedPeapole = new ArrayList<>(this.pepole);
				Collections.sort(sortedPeapole);
				for (Person person : sortedPeapole) {
					System.out.println(person);
				}
				break;

			case 4:
				System.out.println("Thank you and goodbye!");
				break;
			default:
				System.out.println("Invalid choice from menu");

			}
		}
	}

	public void showMenu() {
		System.out.println("Enter your choise:");
		System.out.println("press 1 to Add pepole");
		System.out.println("perss 2 to Delete pepole");
		System.out.println("perss 3 to see all peapole");
		System.out.println("press 4 to Exit");

	}

	public void addPerson(Person p) {
		pepole.add(p);
	}

	public void deletePerson(int id) {
		for (Person person : pepole) {
			if (person.getId() == id) {
				pepole.remove(person);
				System.out.println("person delete");
				break;
			} else {
				System.out.println("person not found" + id);
			}
		}
	}
}
