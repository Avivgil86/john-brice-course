package b.stream;

import java.util.ArrayList;
import java.util.List;

public class Demo3 {

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("Apple");
		str.add("Banana");
		str.add("Orange");
		str.add("apple");
		//Stream<String> stream = str.stream();
		//stream = stream.map(string -> string.toUpperCase());
		//stream.forEach(System.out::println);
	long count =str.stream().map(stri -> stri.toLowerCase()).filter(stri -> stri.startsWith("a")).count();
System.out.println(str);
System.out.println(count);
	}

}
