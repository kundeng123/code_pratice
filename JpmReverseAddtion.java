package code_practice;

import java.util.Scanner;

public class JpmReverseAddtion {

	public JpmReverseAddtion() {
		// TODO Auto-generated constructor stub
	}

	public static long reverNum (long number) {
		long res = 0;
		while(number > 0) {
			res = res * 10 + number%10;
			number = number/10;
		}
		return res;
		
	}
	public static boolean checkOddDigit(long number) {
		boolean res = false;
		while(number>0) {
			long temp = number % 10;
			if(temp % 2 != 0) {
				return true;
			}
			number = number / 10;
		}
		
		return res;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String input = scanner.nextLine();
		
//		System.out.println(input);
	
		scanner.close();
		long number = Long.parseLong(input);
		int iteration = 1;
		while(iteration < 1000 && number < Long.MAX_VALUE) {
			long reverNumber = reverNum(number);
			System.out.println("add " + number + " " + reverNumber);
			number = reverNumber + number;
			if(!checkOddDigit(number) && number < Long.MAX_VALUE) {
				System.out.println("iter: " + iteration);
				System.out.println("result: " + number);
				break;
			}
			else {
				iteration++;
			}
			
		}
	}

}
