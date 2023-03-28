package b.stream;

import java.util.ArrayList;
import java.util.List;

public class Demo2 {

	public static void main(String[] args) {
		List<String> str = new ArrayList<>();
		str.add("aaaa");
		str.add("bbbb");
		str.add("cccc");
		//Stream<String> stream = str.stream();
		//stream = stream.map(string -> string.toUpperCase());
		//stream.forEach(System.out::println);
		str.stream().map(stri -> stri.toUpperCase()).forEach(System.out::println);

	}

}
