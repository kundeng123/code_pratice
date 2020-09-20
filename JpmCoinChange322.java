package code_practice;

import java.util.Arrays;
import java.util.Scanner;

public class JpmCoinChange322 {

	public JpmCoinChange322() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
		System.out.println(input);
	
		scanner.close();
		
		//coin change for 1,3,5
		
		int[] dp = new int[Integer.parseInt(input)+1];
		Arrays.fill(dp, Integer.parseInt(input) + 1);
		int[] coins = new int[] {1,3,5};
		dp[0] = 0;
		for(int i = 1; i<Integer.parseInt(input)+1; i++ ) {
			for(int j = 0; j <coins.length; j++) {
				if(coins[j] <= i) {
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		System.out.println(dp[Integer.parseInt(input)]  );
	}

}
