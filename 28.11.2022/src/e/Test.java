package e;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
		Print print1 = msg -> System.out.println(msg);

		print1.print("this is my massege");

		Print print2 = System.out::println;
		print2.print("this is my meessage");
		List<Integer> list = Arrays.asList(2, 3, 4, 5);
		list.forEach(System.out::println);
	}

}
