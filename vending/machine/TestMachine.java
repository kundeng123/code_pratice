package vending.machine;

import java.util.HashMap;
import java.util.Map;

public class TestMachine {

	public TestMachine() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		VendingMachine vendingMachine = new VendingMachine(0);
		Map<String, Integer> productInventory = new HashMap<>();
		Map<String, Integer> productPrice = new HashMap<>();
		productInventory.put("item1", 5);
		productInventory.put("item2", 10);

		productPrice.put("item1", 5);
		productPrice.put("item2", 6);

		vendingMachine.setInventory(productInventory);
		vendingMachine.setPrice(productPrice);
		
		vendingMachine.collectCash(7);
		System.out.println(vendingMachine.getState().toString());
		vendingMachine.dispense("item1");
		System.out.println(vendingMachine.getState().toString());
		//vendingMachine.getState().dispenseItem("item1");
		vendingMachine.change("item1");
		System.out.println(vendingMachine.getState().toString());
		
		vendingMachine.collectCash(4);
		vendingMachine.dispense("item1");
		//System.out.println(vendingMachine.getState().toString());
		vendingMachine.cancel();
		vendingMachine.collectCash(5);
		vendingMachine.dispense("item1");
		vendingMachine.change("item1");

	}

}
