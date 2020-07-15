package ood_pizza;

public class NYCheesePizza extends Pizza{

	public NYCheesePizza() {
		// TODO Auto-generated constructor stub
		name = "NYCheesePizza";
		sauce = "NY Cheese";
		dough = "NY dough";
	}

	

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("NY cheese bake");

	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("NY cheese cut");

	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("NY cheese box");

	}
}
