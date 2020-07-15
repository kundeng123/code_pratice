package call.center;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CallCenter {

	private static final int NUM_RESPONDENT = 10;
	private static final int NUM_MANAGER = 3;
	private static final int NUM_DIRECTOR = 1;
	private static List<List<Employee>> employees;
	private static Queue<Call> callQueue ;

	private static CallCenter instance;
	private CallCenter() {
		
	}
	public static CallCenter getCallCenterInstance() {
		if(instance == null) {
		// TODO Auto-generated constructor stub
		List<Employee> emp = new ArrayList<>();
		for (int i = 0; i < NUM_RESPONDENT; i++) {

			emp.add(new Respondent());
		}
		employees.add(emp);
		emp.clear();
		for (int i = 0; i < NUM_MANAGER; i++) {

			emp.add(new Manager());
		}
		employees.add(emp);
		emp.clear();
		for (int i = 0; i < NUM_DIRECTOR; i++) {

			emp.add(new Director());
		}
		employees.add(emp);
		callQueue = new LinkedList<>();
		}
		return instance;
	}

	public List<List<Employee>> getEmployees() {
		return employees;
	}

	

	public void setCallQueue(Queue<Call> calls) {
		callQueue = calls;
	}

	public Employee getHandler(Call call) {
		if(call.getLevel() == Level.Respondent) {
			for(Employee emp: employees.get(0)) {
				if (emp.isFree()) {
					return emp;
					
				}
			}
		}
		else if(call.getLevel() == Level.Manager) {
			for(Employee emp: employees.get(1)) {
				if (emp.isFree()) {
					return emp;
					
				}
			}
		}
		else if(call.getLevel() == Level.Director) {
			for(Employee emp: employees.get(2)) {
				if (emp.isFree()) {
					return emp;
					
				}
			}
		}
		
		return null;
	}
	public void dispatchCall(Caller caller) {
		Call call = new Call(caller);
		dispatchCall(call);
	}

	public void dispatchCall(Call call) {
		Employee emp = getHandler(call);
		if(emp != null) {
			emp.assignNewCall(call);
			call.setHandler(emp);
		
		}
		else {
			//FIFO
			callQueue.add(call);
		}
	}
	public boolean assignNewCall(Employee emp) {
		if(callQueue.peek() == null) {
			Call call = callQueue.poll();
			if(call.getLevel() == emp.level) {
				emp.assignNewCall(call);
				call.setHandler(emp);
				
				return true;
			}
		}
		return false;
	}
}
