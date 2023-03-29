package a;

import java.util.concurrent.CountDownLatch;
import java.util.jar.Attributes.Name;

public class Building {
	private boolean floor1Open;
	private boolean floor2Open;
	private boolean floor3Open;
	private CountDownLatch latch = new CountDownLatch(3);

	public Building() {
		super();

	}

	public void OpenFloor(int x) {
		switch (x) {
		case 1: {
			if (!floor1Open) {
				floor1Open = true;
				this.latch.countDown();
			}
			break;

		}
		case 2: {
			if (!floor2Open) {
				floor2Open = true;
				this.latch.countDown();
			}
			break;

		}
		case 3: {
			if (!floor3Open) {
				floor3Open = true;
				this.latch.countDown();
			}
			break;

		}
		default:
			throw new IllegalArgumentException("Unexpected value: " + x);
		}

	}

	public CountDownLatch getLatch() {
		return latch;
	}

	public void enterBuilding(String name) {
		try {
			this.latch.await();
			System.out.println(name + " entered");
		} catch (Exception e) {
			e.getStackTrace();
		}
	}

}
