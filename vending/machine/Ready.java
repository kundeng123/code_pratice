package vending.machine;

public class Ready implements State{
	private VendingMachine machine;
	public Ready(VendingMachine vm) {
		System.out.println("in ready");
		this.machine = vm;
		// TODO Auto-generated constructor stub
	}

	@Override
	public void collectCash(int cash) {
		// TODO Auto-generated method stub
		System.out.println("Collecting cash");
		//this.machine.collectCash(cash);
		this.machine.setState(machine.getDispenseItemState());


	}

	@Override
	public void dispenseItem(String productId) {
		// TODO Auto-generated method stub
		System.out.println("heading to dispense Item");
	}

	@Override
	public void dispenseChange(String productId) {
		System.out.println("wrong state");
	}

	@Override
	public void cancel() {
		// TODO Auto-generated method stub
		System.out.println("cancel transcation");
		this.machine.setState(machine.getCancelState());
		
	}
	@Override
	public String toString() {
		return "this is at ready";
	}
}
