package amazon.locker;

public class Locker {
	private long id;
	private String zipcode;
	private Package pack;
	private Size size;
	private boolean isAvailable;
	public Locker(long id, String zip, Size size) {
		// TODO Auto-generated constructor stub
		this.id = id;
		this.zipcode = zip;
		this.size = size;
		this.isAvailable = true;
	}
	//getter and setter
	public Size getSize() {
		return this.size;
	}
	public String getZip() {
		return this.zipcode;
	}
	
	private boolean canFitPackage(Package pack) {
		if(pack.getSize().getValue() <= this.getSize().getValue() && isAvailable) {
			return true;
		}
		return false;
	}
	public boolean savePackage(Package pack) {
		if(canFitPackage(pack)) {
			this.pack = pack;
			this.isAvailable = false;
			return true;
		}
		return false;
		
	}
	public void removePackage() {
		this.isAvailable = true;
		this.pack = null;
	}
	

}
