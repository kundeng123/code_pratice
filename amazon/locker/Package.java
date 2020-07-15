package amazon.locker;

public class Package {
	private long id;
	private String zipcode;
	private Size size;
	public Package(long id, String zip, Size size) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.size = size;
		this.zipcode = zip;
	}
	public long getId() {
		return id;
	}
	public String getZip() {
		return zipcode;
	}
	public Size getSize() {
		return size;
	}
	

}
