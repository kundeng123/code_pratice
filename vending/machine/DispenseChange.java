package vending.machine;

public class DispenseChange implements State{

	private VendingMachine machine;
	public DispenseChange(VendingMachine vm) {
		System.out.println("in DispenseChange");

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
		if(this.machine.calculateChange(productId) > 0) {
			System.out.println("dispensing change");
			this.machine.setCollectedCash(0);
			this.machine.setState(machine.getReadyState());
			
		}
		
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("wrong state");
	}
	@Override
	public String toString() {
		return "this is at dispense change";
	}
}
