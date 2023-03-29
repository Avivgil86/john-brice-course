package a;

public class GateKeeperThread extends Thread {
	private Student[] students;
	private Building building;

	public GateKeeperThread(Building building, Student[] students) {
		super();
		this.students = students;
		this.building = building;
	}

	@Override
	public void run() {
		for (Student student : students) {
			student.enterBuilding(building);
		}
	}
}