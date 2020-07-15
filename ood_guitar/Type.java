package ood_guitar;

public enum Type {
	ACOUSTIC, ELECTRIC;
	
	public String toString() {
		switch(this) {
		default:
			return "unspecified";
		case ACOUSTIC:
			return "acoustic";
		
		case ELECTRIC:
			return "electric";
			
		}
	}
}
