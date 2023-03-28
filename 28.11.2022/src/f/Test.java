package f;

import java.util.Arrays;
import java.util.List;

public class Test {

	public static void main(String[] args) {
List<Integer>list = Arrays.asList(4,5,67,8);
list.forEach(System.out::println);
System.out.println("============");
Shum shum = new Shum();
 list.forEach(shum::add);
 System.out.println(shum.getSum());
	}

}
