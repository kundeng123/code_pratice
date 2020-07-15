package vending.machine;

public class DispenseItem implements State {
	private VendingMachine machine;
	public DispenseItem(VendingMachine vm) {
		System.out.println("in DispenseItem");

		this.machine = vm;
		// TODO Auto-generated constructor stub
	}
		
	@Override
	public void collectCash(int cash) {
		System.out.println("Wrong state");
		
	}

	
	public void dispenseItem(String productId) {
		System.out.println("here");
		if(this.machine.getCollectedCash() >= this.machine.getPrice(productId)) {
			System.out.println("Dispensing item:" + productId);
			this.machine.removeItem(productId);
			this.machine.setState(machine.getDisnpenseChangeState());
		}
		else {
			System.out.println("Not enough cash");
			this.machine.setState(machine.getCancelState());
		}
	
		
	}

	@Override
	public void dispenseChange(String productId) {
		this.machine.setState(machine.getDisnpenseChangeState());
	}

	@Override
	public void cancel() {
		System.out.println("Wrong state");		
	}
	@Override
	public String toString() {
		return "this is at DispenseItem";
	}
}
