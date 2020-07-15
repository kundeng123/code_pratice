package ood_pizza;

public class ChicagoPizzaStore extends PizzaStore{

	public ChicagoPizzaStore() {
		// TODO Auto-generated constructor stub
	}

	Pizza createPizza(String type) {
		// TODO Auto-generated method stub

		if(type.equals("cheese")) {
			return new ChicagoCheesePizza();
		}
		else if(type.equals("veggie")) {
			return new ChicagoVeggiePizza();
		}
		else {
			return null;
		}
	}

}
