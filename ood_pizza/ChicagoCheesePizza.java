package ood_pizza;

public class ChicagoCheesePizza extends Pizza {

	public ChicagoCheesePizza() {
		// TODO Auto-generated constructor stub
		name = "ChicagoCheesePizza";
		sauce = "Chicago Cheese";
		dough = "chicago dough";
	}
	
	

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("chicago cheese bake");

	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("chicago cheese cut");

	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("chicago cheese box");

	}
}
