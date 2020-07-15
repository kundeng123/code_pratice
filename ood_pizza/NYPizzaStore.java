package ood_pizza;

public class NYPizzaStore extends PizzaStore{

	public NYPizzaStore() {
		// TODO Auto-generated constructor stub
	}

	Pizza createPizza(String type) {
		// TODO Auto-generated method stub

		if(type.equals("cheese")) {
			return new NYCheesePizza();
		}
		else if(type.equals("veggie")) {
			return new NYVeggiePizza();
		}
		else {
			return null;
		}
		
	}

}
