package vending.machine;

public interface State {
	public void collectCash(int cash);
	public void dispenseItem(String productId);
	public void dispenseChange(String productId);
	public void cancel();
	
}
