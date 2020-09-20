package code_practice;

import java.util.Arrays;
import java.util.Scanner;

public class JpmMthFromLast {

	public JpmMthFromLast() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		while(scanner.hasNext()) {
		String[] input = scanner.nextLine().split(" ");
		
		System.out.println(Arrays.asList(input));
		int index = input.length - Integer.parseInt(input[input.length-1] ) - 1;
		System.out.println(input[input.length-1] + "th from last element is " + input[index]);
		
		//return input
		}
		scanner.close();

	}

}
