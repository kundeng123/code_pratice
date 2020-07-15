package call.center;

public abstract class Employee {
	public Level level;
	public Call call;
	public Employee() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Level getLevel() {
		return level;
	}
	public void receiveCall() {
		
	}
	public void completeCall() {
		
	}
	public void reassignCall() {
		
	}
	public void assignNewCall(Call call) {
		this.call = call;
		
	}
	public boolean isFree() {
		if(call == null) {
			return true;
		}
		return false;
	}
}
