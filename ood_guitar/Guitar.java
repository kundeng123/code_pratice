package ood_guitar;

public class Guitar {
	public String serialNumber;
	public double price;
	public String builder;
	public String model;
	public Type type;
	public String backWood;
	public String topWood;
	
	public Guitar(String serialNumber, double price, String builder, String model, Type type, String backWood, String topWood) {
		this.serialNumber = serialNumber;
		this.price = price;
		this.builder = builder;
		this.model = model;
		this.type = type;
		this.backWood = backWood;
		this.topWood = topWood;
	}
	public String getSerialNumber() {
		return this.serialNumber;
	}
	public double getPrice() {
		return this.price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public String getBuilder() {
		return this.builder;
	}
	public String getModel() {
		return this.model;
	}
	public Type getType() {
		return this.type;
	}
	public String getBackWood() {
		return this.backWood;
	}
	public String getTopWood() {
		return this.topWood;
	}
	
}
	
