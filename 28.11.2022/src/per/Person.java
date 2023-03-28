package per;

public class Person {
	private int id;
	private String name;
	private int bithdate;

	public Person() {

	}

	public Person(int id, String name, int bithdate) {
		super();
		this.id = id;
		this.name = name;
		this.bithdate = bithdate;
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

	public int getBithdate() {
		return bithdate;
	}

	public void setBithdate(int bithdate) {
		this.bithdate = bithdate;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", bithdate=" + bithdate + "]";
	}

}
