package ood_pizza;

public class NYVeggiePizza extends Pizza{

	public NYVeggiePizza() {
		// TODO Auto-generated constructor stub
		name = "NYVeggiePizza";
		sauce = "NY veggie";
		dough = "NY veggie dough";
	}
	
	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("NY Veggie bake");

	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("NY Veggie cut");

	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("NY Veggie box");

	}
}
