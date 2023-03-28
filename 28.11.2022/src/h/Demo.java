package h;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class Demo {
	public static void main(String[] args) {
		Predicate<Integer> greaterThen100 = x -> x > 100;
		if (greaterThen100.test(99)) {
			System.out.println("Yes greaterThen100");
		} else {
			System.out.println("No greaterThen100");
		}
		Predicate<String> upTo25 = msg -> msg.length() <= 5;
		if (upTo25.test("Hello")) {
			System.out.println("Yes up upTo25");
		} else {
			System.out.println("Not up upTo25");
		}
		List<String> list = new ArrayList<>(Arrays.asList("abbb", "bbbb", "cccccc", "ddd"));
		System.out.println(list);

		list.removeIf(str ->  str.startsWith("a") && str.length() > 5 );
		System.out.println(list);
	}
}
