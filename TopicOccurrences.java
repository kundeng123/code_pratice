package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopicOccurrences {

	public static List<String> preProcess(List<String> reviews){
		List<String> result = new ArrayList<String>();
		
		for(String msg:reviews) {
			msg = msg.replaceAll("[^A-Za-z0-9 ]", "").replaceAll("\\s+", " ");;
//			System.out.println(msg);
			result.add(msg.toLowerCase());
		}
		
		return result;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Map<String, List<String>> topics = new HashMap<String, List<String>>();
		topics.put("Price", Arrays.asList(new String[] { "Cheap", "Expensive", "Price" }));
		topics.put("Business", Arrays.asList(new String[] { "Burger", "Cheese" }));
		topics.put("Hello World", Arrays.asList(new String[] { "Hello World" }));

		List<String> review = new ArrayList<String>();
		review.add("Hello  @# World is cheap!! #$%");
		review.add("Expensive !is not good, price is wrong");
		review.add("love my burger234");
		review.add("asd");
		review.add("asd Burger");


		//result : price: 3, business 1, hello world 1
		Map<String, Integer> result = new HashMap<String, Integer>();
		List<String> cleanReview  = preProcess(review);
		
		for(String str: cleanReview) {
			for(String key:topics.keySet()) {
				if(!result.containsKey(key)) {
					result.put(key, 0);
				}
				for(int i =0; i<topics.get(key).size(); i++) {
					if(str.contains(topics.get(key).get(i).toLowerCase())) {
						int cnt = str.split(topics.get(key).get(i).toLowerCase(),-1).length-1;
						System.out.println("reviews: " + str);
						System.out.println(topics.get(key).get(i).toLowerCase()+" cnt:" + cnt);
						result.put(key, result.get(key)+ cnt);
					}
				}
			}
		}
		System.out.println("map:" + result);
	}
}
