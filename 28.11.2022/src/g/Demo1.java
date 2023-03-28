package g;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

public class Demo1 {
	public static void main(String[] args) {
		
		Function<String, Integer> stringLengthfunction =t -> t.length(); 
		String str = "aaaa";
		System.out.println(str);
		int length  = stringLengthfunction.apply(str);
		System.out.println(length);
		
		System.out.println("=================");
		
		Predicate<Integer>predicate = t -> t %7 ==0;
		boolean answer = predicate.test(70);
		System.out.println(answer);
		
		Predicate<Integer>predicate2 = t -> t>100;
		boolean ans = predicate2.test(300);
		System.out.println(ans);
		
		Predicate<String> predicate3 = t -> t.length() <=25;
		boolean answ = predicate3.test("hello world");
		System.out.println(answ);
		Predicate<Integer> predicate4 = t -> t %2 !=0;
		
		List<Integer> integers = new ArrayList<>();
		integers.addAll(Arrays.asList(2,4,6,1,9,8));
		integers.removeIf(predicate4);	
		System.out.println(integers);}
	}
