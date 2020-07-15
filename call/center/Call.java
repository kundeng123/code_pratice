package call.center;

public class Call {
	private Level level; //min employee can handle it
	private Caller caller;
	private Employee handler;
	
	public Call(Caller caller) {
		// TODO Auto-generated constructor stub
		this.caller = caller;
	}

	public Level getLevel() {
		return level;
	}
	public void setLevel(Level level) {
		this.level = level;
	}
	public Caller getCaller() {
		return caller;
	}
	public void setCaller(Caller caller) {
		this.caller = caller;
	}
	public Employee getHandler() {
		return this.handler;
	}
	public void setHandler(Employee employee) {
		this.handler = employee;
	}
	
}
