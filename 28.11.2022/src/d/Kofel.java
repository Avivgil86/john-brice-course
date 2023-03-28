package d;

@FunctionalInterface
public interface Kofel {
	double kfol(double x);

	static void doSomething() {
		System.out.println( "doing something");
	}
	default void doSomethingElse() {
		System.out.println("doing something else");
	}
}
