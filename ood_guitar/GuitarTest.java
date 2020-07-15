/**
 * 
 */
package ood_guitar;

/**
 * @author kun.deng
 *
 */
public class GuitarTest {

	/**
	 * 
	 */
	public GuitarTest() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Inventory inventory = new Inventory();
		

	}
	public void initialInventory(Inventory inventory) {
		Guitar guitar = new Guitar("AAA", 123.0, "builder1", "model1", Type.ACOUSTIC, "backwood1", "topwood1");
		Guitar guitar2 = new Guitar("BBB", 100.0, "builder2", "model2", Type.ACOUSTIC, "backwood2", "topwood2");
		Guitar guitar3 = new Guitar("CCC", 225.0, "builder3", "model3", Type.ELECTRIC, "backwood3", "topwood3");
		Guitar guitar4 = new Guitar("DDD", 50.0, "builder4", "model4", Type.ELECTRIC, "backwood4", "topwood4");

		inventory.addGuitar(guitar);
		inventory.addGuitar(guitar2);
		inventory.addGuitar(guitar3);
		inventory.addGuitar(guitar4);

	}

}
