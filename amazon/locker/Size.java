package amazon.locker;

public enum Size {
	Small(0), Medium(1), large(2);
	private int value;
	private Size(int val) {
		this.value = val;
	}
	public int getValue() {
		return value;
	}
}
