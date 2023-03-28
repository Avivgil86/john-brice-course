package a;

public class Person {
	public void speak() {
		System.out.println("bla");

	}

	public static void main(String[] args) {
		Person person = new Person();
		person.speak();

		Person person2 = new Person() {

			@Override
			public void speak() {
				System.out.println("bla bla");
			}
		};
		person2.speak();
	}
}
