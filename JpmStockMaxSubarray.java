package code_practice;

import java.util.Arrays;
import java.util.Scanner;

public class JpmStockMaxSubarray {

	public JpmStockMaxSubarray() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scanner = new Scanner(System.in);
		String input[] = scanner.nextLine().split(" ");
		
		System.out.println(Arrays.asList(input));
	
		scanner.close();
		//find the maximum profit
		//[2 -1 6 5 -5]
		int result = Integer.MIN_VALUE;
		int currentMax = 0;
		for(int i = 1; i <input.length; i++) {
			currentMax = Math.max(currentMax + Integer.parseInt(input[i]), Integer.parseInt(input[i]));
			result = Math.max(result, currentMax);
		}
		System.out.println(result < 0? 0: result);
		
	}

}
