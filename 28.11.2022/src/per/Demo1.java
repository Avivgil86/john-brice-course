package per;

import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Supplier;
import java.util.function.UnaryOperator;


public class Demo1 {
	static int id = 101;

	public static void main(String[] args) {
		UnaryOperator<String> toUperCase = x -> x.toUpperCase();
		String x = "aviv";
		x = toUperCase.apply(x);
		System.out.println(x);
		System.out.println("===================================");
		BinaryOperator<String> together = (d, y) -> d + y;
		BinaryOperator<Integer> together1 = Integer::sum;
		String sum = together.apply("aaa", "bbb");
		Integer sum1 = together1.apply(12, 33);
		System.out.println(sum);
		System.out.println(sum1);

		System.out.println("===================================");
		Supplier<Integer> random = () -> (int) (Math.random() * 101);
		System.out.println(random.get());
		System.out.println("==============================");
		Supplier<Person> supplier = () -> {
			Person person = new Person();
			person.setBithdate(random.get());
			String[] names = { "aaa", "bbb", "ccc" };
			person.setName(names[random.get() % names.length]);
			person.setId(id++);
			return person;
		};
		Person p1 = supplier.get();
		Person p2 = supplier.get();
		Person p3 = supplier.get();
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		System.out.println("===================================");
		
		Consumer<Line> twice = line -> line.setLength(line.getLength() * 2);

		Line line = new Line();
		line.setLength(10);
		System.out.println(line);

		twice.accept(line);
		System.out.println(line);

	
	}

}
