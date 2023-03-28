package per;

public class Line {
	private int length;

	public Line(int length) {
		super();
		this.length = length;
	}

	public Line() {

	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	@Override
	public String toString() {
		return "Line [length=" + length + "]";
	}

}
