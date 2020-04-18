package code_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BusinessLocation {
    public List<Store> stores;

    private class Store {
        String name;
        String city;
        int businessID;

        public Store(String n, String c, int b) {
            name = n;
            city = c;
            businessID = b;
        }
    }
    public BusinessLocation() {
        stores = new ArrayList<>();
        stores.add(new Store("Walmart", "San Jose", 1));
        stores.add(new Store("Walmart", "Los Angeles", 2));
        stores.add(new Store("Bestbuy", "San Jose", 3));
        stores.add(new Store("Bestbuy", "Los Angeles", 4));
        stores.add(new Store("Bestbuy", "Dallas", 5));
        stores.add(new Store("Bed&Bath", "San Jose", 6));
        stores.add(new Store("Bestbuy", "San Jose", 7));
        stores.add(new Store("Bestbuy", "San Jose", 8));
        stores.add(new Store("Walmart", "San Jose", 9));
        stores.add(new Store("Walgreen", "San Jose", 10));
        stores.add(new Store("Walgreen", "San Jose", 11));
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BusinessLocation bl = new BusinessLocation();
		List<Store> stores = bl.stores;
		String city = "San Jose";
		//Find store names and numbers in San Jose
		Map<String, Integer> storeCnt = new HashMap<String, Integer>();
		for(Store item : stores) {
			if(item.city.equalsIgnoreCase(city)) {
				storeCnt.put(item.name, storeCnt.getOrDefault(item.name, 0)+1);
			}
		}
		System.out.println("map: "+ storeCnt);
		List<Map.Entry<String,Integer>> res = new ArrayList<Map.Entry<String,Integer>>(storeCnt.entrySet());
		Collections.sort(res, new Comparator<Map.Entry<String, Integer>>() {
			//This method returns zero if the objects are equal. 
			//It returns a positive value if obj1 is greater than obj2. Otherwise, a negative value is returned. 
            public int compare(Map.Entry<String, Integer> o1,
                               Map.Entry<String, Integer> o2) {
            	 if (o1.getValue() < o2.getValue()) {
                     return o1.getValue().compareTo(o2.getValue()); //o1 < o2, return negative
                 } else if (o1.getValue().equals(o2.getValue())) {
                     return o1.getKey().compareTo(o2.getKey()); //if o1 key < o2 key, return negative
                 } else {
                     return o1.getValue().compareTo(o2.getValue());
                 }
                //return (o1.getValue()).compareTo(o2.getValue());
            }
        });
		System.out.println("after sort map: "+ res);
	}

}
