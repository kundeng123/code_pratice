package code_practice;

import java.util.Arrays;
import java.util.Scanner;

public class JpmBeautyString {

	public JpmBeautyString() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
//		System.out.println(input);
	
		scanner.close();
		
		//O(n)
		String sanitized = input.replaceAll("[^a-zA-Z]", "").toLowerCase();
		int[] count = new int[26];
		for(int i = 0; i <sanitized.length(); i++) {
			++count[sanitized.charAt(i) - 'a'];
		}
		//O(n*log(n))
		Arrays.sort(count);
		int result = 0;
		for(int i = 25; i>=0 && count[i] > 0; i-- ) {
			result += count[i] * (i+1);
		}
		System.out.println("beauty is: " + result);
	}

}
