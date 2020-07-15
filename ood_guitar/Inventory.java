package ood_guitar;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import ood_guitar.*;

public class Inventory {
	public List<Guitar> guitars;
	
	public Inventory() {
		this.guitars = new ArrayList<>();
	}
	public void addGuitar(String serialNumber, double price, String builder, String model, Type type, String backWood, String topWood ) {
		Guitar guitar = new Guitar(serialNumber,price, builder, model, type, backWood, topWood);
		this.guitars.add(guitar);
	}
	public void addGuitar(Guitar guitar) {
		this.guitars.add(guitar);
		}
	public Guitar getGuitar(String serialNumber) {
		Iterator i = guitars.iterator();
		while(i.hasNext()) {
			Guitar guitar = (Guitar) i.next();
			if(guitar.getSerialNumber().equalsIgnoreCase(serialNumber)) {
				return guitar;
				
			}
		}
		return null;
	}
	public void search() {
		//return guitar 
	}
}
