package per;

import java.util.ArrayList;
import java.util.List;

public class Test {

	public static void main(String[] args) {

		List<Person>list = new ArrayList<>();
		int i = 1;
		int m = 18;
		for (int j = 0; j < 9; j++) {
			i++;
			String name = "moshe"+i;
			m++;
			int age = m;
			Person person = new Person(i, name, age);
			list.add(person);	
		}
		for (Person person : list) {
			System.out.println(person);
		}
		list.removeIf(s -> s.getBithdate() > 18);
		System.out.println(list);
	}

}
