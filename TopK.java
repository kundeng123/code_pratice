package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopK {

	 public static List<String> topKFrequent(String[] words, String[] reviews, int k) {
	        Map<String, Integer> count = new HashMap();
	        HashSet<String> counted = new HashSet<>();
	        List<String> keyWords = Arrays.asList(words);
	        for(int i = 0; i < reviews.length; i++) {
	        	for(String s: reviews[i].split("\\W")) {
	        		System.out.println("s=" + s);
	        		if(keyWords.contains(s)) {
	        			count.put(s, count.getOrDefault(s, 0) + 1);
	        		}
	        	}
	        }
	        System.out.println(count);
	        List<String> results = new ArrayList<>(count.keySet());
	        Collections.sort(results, (ob1, ob2) -> count.get(ob1).equals(count.get(ob2)) ?  ob1.compareTo(ob2) : count.get(ob2) - count.get(ob1));
	        return results;
	    }
	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int k1 = 2;
		String[] keywords1 = { "anacell", "cetracular", "betacellular" };
		String[] reviews1 = {"Anacell provides the best services in the city",
                "betacellular has awesome services, betacellular, betacellular",
                "Best services provided by anacell, everyone should use anacell"};
		List<String> result = topKFrequent(keywords1, reviews1, k1);
		System.out.println(result);
	}

}
