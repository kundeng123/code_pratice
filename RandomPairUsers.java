package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.jar.Attributes.Name;

public class RandomPairUsers {

	static class User {
		String name;

		public User(String name) {
			this.name = name;
		}
	}

	public static ArrayList<ArrayList<String>> randomMatch(List<String> names, int matchSize) {
		ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
		int[] pointers = new int[3];
		int r = 0; // pointer to pointers
		int i = 0; // pointer to names
		int k = 2; // number of names to matched
		while (r >= 0) {
			// System.out.println("i: " + i + " r: " + r);
			if (i <= (names.size() + r - k)) {
				pointers[r] = i;

				if (r != k - 1) {
					i = pointers[r] + 1;
					r++;
				} else {
					ArrayList<String> pairs = new ArrayList<String>();
					pairs.add(names.get(pointers[0]));
					pairs.add(names.get(pointers[1]));
					// pairs.add(names.get(pointers[2]));
					// System.out.println(pairs);
					result.add(pairs);
					i++;
				}

			} else {
				r--;
				if (r >= 0) {
					i = pointers[r] + 1;
				}
			}

		}
		return result;
	}

//	public static void matchUserAdvanced(ArrayList<ArrayList<String[]>> last_n_pair, ArrayList<ArrayList<String>>  fullList) {
//		HashMap<>
//	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<String> names = new ArrayList<String>();
		names.add("Mike");
		names.add("Mary");
		names.add("Nicole");
		names.add("Ann");
		ArrayList<ArrayList<String>> result = randomMatch(names, 2);
//		System.out.println(result);
		
		ArrayList<ArrayList<String[]>> last_n_pair = new ArrayList<ArrayList<String[]>>();
		ArrayList<String[]> entry = new ArrayList<String[]>();
		entry.add(new String[] {"Mike, Mary", "Ann, Nicole", "Ann, Mike"});
		last_n_pair.add(entry);
		ArrayList<String[]> entry2 = new ArrayList<String[]>();
		entry.add(new String[] {"Mike, Nicole", "Ann, Mary", "Mary, Nicole"});
		// Create a Random object
		Random rand = new Random();

		ArrayList<ArrayList<String>> result2 = new ArrayList<ArrayList<String>>();
		//O(T): O(n^2);
		for(int i = 0; i<names.size(); i++) {
			//int randomNum = rand.nextInt((names.size() -i ) + 1) + i+1;
			for(int j = i+1; j < names.size(); j++) {
				ArrayList<String> pairs = new ArrayList<String>();
				pairs.add(names.get(i));
				pairs.add(names.get(j));
				result2.add(pairs);
			}
			
			 
		}
		System.out.println(result2);
		
//		random.sample(names, 2);
		
	}
}
