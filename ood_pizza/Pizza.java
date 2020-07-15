package ood_pizza;

public abstract class Pizza {
	String name;
	String sauce;
	String dough;

	public Pizza() {
		// TODO Auto-generated constructor stub
	}

	void prepare() {
		System.out.println("preparing " + name);
		System.out.println("adding souce " + sauce);
		System.out.println("tossing dough  " + dough);
	}
	public abstract void bake();
	public abstract void cut();
	public abstract void box();

}
