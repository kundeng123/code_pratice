package ood_pizza;

public class ChicagoVeggiePizza extends Pizza{

	public ChicagoVeggiePizza() {
		// TODO Auto-generated constructor stub
		name = "ChicagoVeggidPizza";
		sauce = "Chicago veggie";
		dough = "chicago veggie dough";
	}

	

	@Override
	public void bake() {
		// TODO Auto-generated method stub
		System.out.println("chicago veggie bake");

	}

	@Override
	public void cut() {
		// TODO Auto-generated method stub
		System.out.println("chicago veggie cut");

	}

	@Override
	public void box() {
		// TODO Auto-generated method stub
		System.out.println("chicago veggie box");

	}

}
