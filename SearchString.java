package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SearchString {
	/**
	* [
	  {"business_name": "Burger King"},
	  {"business_name": "McDonald's"},
	  {"business_name": "Bob’s Burgers"},
	  {"business_name": "Five Guys"},
	  {"business_name": "Super Duper Burgers"},
	  {"business_name": "Wahlburgers"}
	]

	然后搜索
	query: "bur"
	*/
	List<Business> list = new ArrayList<Business>();
	public SearchString() {
		
		Business a = new Business("Burger King");
		Business b = new Business("McDonald's");
		Business c = new Business("Bob’s Burgers");
		Business d = new Business("Five Guys");
		Business e = new Business("Super Duper Burgers");
		Business f = new Business("Wahlburgers");
		list.add(a);
		list.add(b);
		list.add(c);
		list.add(d);
		list.add(e);
		list.add(f);

	}
		
	public void findLps(String pattern, int[] lps) {
		int M = lps.length;
		int i = 1;
		int len = 0;
		lps[0] = 0;
		
		while(i < M) {
			if(pattern.charAt(i) == pattern.charAt(len)) {
				len++;
				lps[i] = len;
				i++;
			}
			else {
				if (len == 0) {
					lps[i] = len;
					i++;
				}
				else {
					len = lps[len-1];
				}
			}
		}
	}
	class Business {
		String name;
		public Business(String name) {
			this.name = name;
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SearchString st = new SearchString();
		List<Business> blst = st.list;
		String prefix = "bur";
		for (Business bs: blst) {
			String[] arr = bs.name.toLowerCase().split(" ");
			for(String str:arr) {
				if(str.startsWith(prefix)) {
					System.out.println("simple prefix matched:" + bs.name);
					break;
				}
			}
		}
		int[] lps = new int[prefix.length()];
		
		st.findLps(prefix, lps);
		
		System.out.println("lps:" + Arrays.toString(lps));
		
		int M = prefix.length();
		for(Business bs:blst) {
			int N = bs.name.length();
			int j = 0; //index of pattern
			int i = 0; //index of bs name
			while(i < N) {
				if (prefix.charAt(j) == bs.name.toLowerCase().charAt(i)) {
					i++;
					j++;
				}
				if( j == M) {
					System.out.println("find a match:" + bs.name + ", at index:" + (i-j));
					j = lps[j-1];
				}
				else if(i < N && prefix.charAt(j) != bs.name.toLowerCase().charAt(i)) {
					if(j == 0) {
						i++;
					}
					else {
						j = lps[j-1];
					}
				}
			}
		}
	}

}
