package vending.machine;

public class Cancel implements State{

	private VendingMachine machine;
	public Cancel(VendingMachine vm) {
		System.out.println("in Cancel");

		this.machine = vm;
		// TODO Auto-generated constructor stub
		

	}

	@Override
	public void collectCash(int cash) {
		// TODO Auto-generated method stub
		System.out.println("wrong state");
		
	}

	@Override
	public void dispenseItem(String productId) {
		// TODO Auto-generated method stub
		System.out.println("wrong state");
		
	}

	@Override
	public void dispenseChange(String productId) {
		// TODO Auto-generated method stub
		System.out.println("wrong state");
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("canceled");
		this.machine.setCollectedCash(0);
		this.machine.setState(machine.getReadyState());
	}
	@Override
	public String toString() {
		return "this is at cancel";
	}
}
