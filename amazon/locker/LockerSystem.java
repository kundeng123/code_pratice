package amazon.locker;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class LockerSystem {
	Stack<Locker> smallLockers = new Stack<>();
	Stack<Locker> mediumLockers = new Stack<>();
	Stack<Locker> largeLockers = new Stack<>();
	
	Map<Long, Locker> usedLockers = new HashMap<Long, Locker>();
	public LockerSystem() {
		// TODO Auto-generated constructor stub
		
	}
	
	public Locker checkAvailable(Package pack) {
		if(pack.getSize() == Size.Small) {
			for(Locker item : smallLockers) {
				if(item.savePackage(pack)) {
					return item;
				}
			}
		}
		return null;
	}
	public void savePacke(Package pack) {
		Locker locker = checkAvailable(pack);
		if(locker != null) {
			usedLockers.put(pack.getId(), locker);
			locker.savePackage(pack);
		}
		else {
			throw new RuntimeException();
		}
		
	}
	public Locker searchPackage(long id) {
		return usedLockers.get(id);
	}
}
