package demo_drill_for_test;

import java.time.LocalDate;
import java.util.Objects;

public class Person implements Comparable<Person> {
	private int id;
	private String name;
	private LocalDate birthday;

	public Person(int id, String name, LocalDate birthday) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
	}

	public Person() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		return id == other.id;
	}

	@Override
	public int compareTo(Person p) {
		return this.getBirthday().compareTo(p.getBirthday());

	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", birthday=" + birthday + "]";
	}

}
