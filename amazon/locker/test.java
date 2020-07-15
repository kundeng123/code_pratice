package amazon.locker;

enum Size1{
	SMALL(0), MEDIUM(1), LARGE(2);
	private int size;
	public int getSize() {
		return size;
	}
	private Size1(int size) {
		this.size = size;
	}
	
}
public class test {

	public test() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("size:" + Size1.SMALL.getSize());
	}

}
