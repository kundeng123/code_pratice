package call.center;

public enum Level {
	
	Respondent(0), Manager(1), Director(2);
	private int value;
	
	private Level(int value) {
		this.value = value;
	}
	public int getValue() {
		return value;
	}
}
