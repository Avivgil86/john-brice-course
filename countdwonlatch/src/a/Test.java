package a;

public class Test {

	public static void main(String[] args) {
		Building building = new Building();
		Student[] students = new Student[5];
		for (int i = 0; i < students.length; i++) {
			Student student = new Student("student: " + i);
			students[i] = student;
		}
		GateKeeperThread gateKeeperThread = new GateKeeperThread(building, students);
		gateKeeperThread.start();
		OpenControllerThread controllerThread = new OpenControllerThread(building);
		controllerThread.start();
	}

}
