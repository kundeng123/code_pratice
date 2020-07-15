package ood_pizza;

public class TestPizzaStore {

	public TestPizzaStore() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PizzaStore ny = new NYPizzaStore();
		ny.orderPizza("cheese");
		PizzaStore chicago = new ChicagoPizzaStore();
		chicago.orderPizza("veggie");
	}

}
