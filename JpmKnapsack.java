package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class JpmKnapsack {

	public JpmKnapsack() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		int L = 0;
		int N = 0;
		String[] input = scanner.nextLine().split(" ");
		 L = Integer.parseInt(input[0]);
		 N = Integer.parseInt(input[1]);
		List<Integer[]> list = new ArrayList<Integer[]>();
		int count = 0;
		while(count<N) {
		input = scanner.nextLine().split(" ");
//		int[] item = new int[] {Integer.parseInt(input[0], Integer.parseInt(input[1]))};
		list.add(new Integer[] {Integer.parseInt(input[0]), Integer.parseInt(input[1])});
		count++;
		}
//		String[] input2 = scanner.nextLine().split(" ");
		//L is max weight he can put, N is # of types of products
		//wt[] weight of items
		//val[] values of items
		scanner.close();
//		int[] wt = new int[] {
//		System.out.println(Arrays.asList(input));
		int[][] dp = new int[N+1][L+1];
		for(int i = 0; i <N+1; i++) {
			for(int w =0; w <L+1; w++) {
				if(i == 0 || w == 0) {
					dp[i][w] = 0;
				}
				else if(list.get(i - 1)[1] <= w) {
					dp[i][w] = Math.max(list.get(i-1)[0] + dp[i-1][w - list.get(i-1)[1]] , dp[i-1][w]);
				}
				else {
					dp[i][w] = dp[i-1][w];
				}
			}
		}
		System.out.println(dp[N][L]);
	}

}
