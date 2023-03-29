package a;

import java.util.Scanner;

public class OpenControllerThread extends Thread {
	private Building building;

	public OpenControllerThread(Building building) {
		super();
		this.building = building;
		this.setDaemon(true);
	}

	@Override
	public void run() {
		try (Scanner scanner = new Scanner(System.in)) {
			while (true) {
				System.out.println("witch floor to open:");
				int floor = Integer.parseInt(scanner.nextLine());
				building.OpenFloor(floor);
			}

		}
	}
}
