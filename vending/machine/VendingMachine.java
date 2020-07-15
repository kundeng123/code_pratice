package vending.machine;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class VendingMachine {

	private State ready;
	private State dispenseItem;
	private State dispenseChange;
	private State cancel;
	
	private State state ;
	private int cash;
	private Map<String, Integer> productInventory;
	private Map<String, Integer> productPrice;
	private int collectedCash;
	public VendingMachine(int cash) {
		//initial inventory and products
		productInventory = new HashMap<>();
		productPrice = new HashMap<>();
		this.cash = cash;
		this.ready = new Ready(this);
		this.dispenseItem = new DispenseItem(this);
		this.dispenseChange = new DispenseChange(this);
		this.cancel = new Cancel(this);
		this.state = ready;
		// TODO Auto-generated constructor stub
	}
	public void setInventory(Map<String, Integer> productInventory) {
		this.productInventory = productInventory;
	}
	public void setPrice(Map<String, Integer> price) {
		this.productPrice = price;
	}
	//setter and getter
	public void setState(State state) {
		this.state = state;
	}
	 
	public State getState() {
		return this.state;
	}
	public void collectCash(int cash) {
		this.collectedCash += cash;
		this.state.collectCash(cash);
	}
	public int calculateChange(String productId) {
		System.out.println("dispense change: " + (collectedCash - productPrice.get(productId)));
		return collectedCash - productPrice.get(productId);
	}
	public void change(String productId) {
		state.dispenseChange(productId);
	}
	public void dispense(String productId) {
		if(this.state == null) {
			System.out.println("null");
		}
		state.dispenseItem(productId);
	}
	public void cancel() {
		state.cancel();
	}
	public int getCollectedCash() {
		return collectedCash;
	}
	public void  setCollectedCash(int cash) {
		this.collectedCash = cash;
	}
	public int getPrice(String productId) {
		return productPrice.get(productId);
	}
	public void removeItem(String productId) {
		int count = productInventory.get(productId);
		productInventory.put(productId, count-1);
		
	}
	public State getReadyState() {
		return this.ready;
	}
	public State getDispenseItemState() {
		return this.dispenseItem;
	}
	public State getDisnpenseChangeState() {

		return this.dispenseChange;
	}
	public State getCancelState() {
		return this.cancel;
	}
}
