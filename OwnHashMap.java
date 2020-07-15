package code_practice;

class Entry<K, V>{
	private K key;
	private V val;
	private Entry<K,V> next ;
	
	public Entry(K k, V v){
		this.key = k;
		this.val = v;
		this.next = null;
	}
	public K getKey() {
		return this.key;
	}
	public V getValue() {
		return this.val;
	}
	public void setKey(K key) {
		this.key = key;
	}
	public void setVal(V value) {
		this.val =value;
	}
	
	@Override
	public int hashCode() {
		return key.hashCode();
	}
	@Override
	public boolean equals(Object obj) {
		//System.out.println("here");
		if(this == obj) {
			return true;
		}
		if(obj == null || this.getClass() != obj.getClass()) {
			return false;
		}
		Entry entry = (Entry) obj;
		if(this.key != entry.getKey()) {
			return false;
		}
		if(this.key == entry.getKey() &&
				(this.val == entry.getValue() 
				|| this.val.equals(entry.getValue()))) {
			return true;
		}
		return false;
	}
	
	public void setNext(Entry<K,V> next) {
		this.next = next;
	}
	public Entry<K,V> getNext(){
		return this.next;
	}
	
}
/*
 * That's the generic type declaration of the class. For example, to specify that a map is going to use strings as keys and integers as values:

 */
public class OwnHashMap<K,V> {

	public int capacity = 10;
	public Entry<K,V>[] buckets;
	
	
	
	public OwnHashMap() {
		// TODO Auto-generated constructor stub
		buckets = new Entry[capacity];
	}

	public int hashing(int hashcode) {
		int location = hashcode % capacity;
		//System.out.println("location: " + location);
		return location;
	}
	
	public V get(K key) {
		
		int location = hashing(key.hashCode());
		Entry<K, V> entry = buckets[location];
		if(entry != null) {
			while(!key.equals(entry.getKey()) && entry!= null) {
					entry = entry.getNext();
				}
			}
		
		return entry == null? null : entry.getValue();
	}
	public void put(K key, V value) {
		if(key == null) {
			throw new RuntimeException("can't be null");
		}
		int location = hashing(key.hashCode());
		Entry<K, V> entry = buckets[location];
		if(entry == null) {
			//create new entry
			buckets[location] = new Entry<K, V>(key, value);
			
		}
		else {
			//loop all entrys to find the one to update
			//System.out.println(entry.getKey());
			//System.out.println(key);
			//System.out.println(key.equals(entry.getKey()));
			while(true) {
				K keytemp = entry.getKey();
				if(key.equals(keytemp)) {
					entry.setVal(value);
					break;
				}
				else if (entry.getNext() == null) {
					entry.setNext(new Entry<K,V>(key, value));
					break;
				}
				entry = entry.getNext();
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OwnHashMap<String, Integer> map = new OwnHashMap<String, Integer>();
		map.put("key1", 1);
		map.put("key1", 2);
		map.put("key2", 1);
		//map.put(null, 100);
		System.out.println(map.get("key1"));
		System.out.println(map.get("key2"));
		System.out.println(map.get("key3"));
		System.out.println(map.get("key2"));
		//System.out.println(map.get(""));

	}

}
