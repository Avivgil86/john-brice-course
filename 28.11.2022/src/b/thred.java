package b;

public class thred {
	public static void main(String[] args) {

		Thread thread = new Thread(() -> System.out.println("hello"));
		thread.start();
	}
}