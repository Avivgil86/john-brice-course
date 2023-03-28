package b.stream;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Demo {

	public static void main(String[] args) {
		List<Integer> nums = Arrays.asList(1, 1, 2, 3, 34, 3, 5, 5, 67);
		nums.stream().peek(e -> System.out.println("===" + e)).distinct().forEach(System.out::println);
		System.out.println("=====================");
		List<Integer> nums1 = Arrays.asList(18, 1, 2, 3, 34, 3, 5, 5, 67);
		boolean b = nums1.stream().anyMatch(e -> e == 18);
		System.out.println(b);
		System.out.println("==============");
		Set<Integer> nums2 = new HashSet<>(Arrays.asList());
		Optional<Integer> opt = nums2.stream().findAny();
		if (opt.isPresent()) {
			System.out.println(opt.get());

		} else {
			System.out.println("NONE");
		}
		System.out.println("==============");
		int x = nums2.stream().findAny().orElseGet(() -> -1);
		System.out.println(x);

		List<Integer> nums3 = Arrays.asList(18, 11, 22, 3, 34, 3, 5, 5, 67);
		System.out.println("==============");

		Integer minu = nums3.stream().min((m, m1) -> m.compareTo(m1)).get();
		System.out.println(minu);
		System.out.println("==============");
		List<Integer> nums4 = Arrays.asList(18, 11, 22, 3, 34, 3, 5, 5, 67);
		int theSum = nums4.stream().reduce((sum, e) -> sum += e).get();
		System.out.println(theSum);
		System.out.println("==============");
		List<Integer> nums5 = Arrays.asList(18, 11, 22, 3, 34, 3, 5, 5, 67);
		Integer[] arr = nums5.stream().map(e -> e * 2).toArray((size) -> new Integer[size]);
		System.out.println(Arrays.toString(arr));

	}

}
