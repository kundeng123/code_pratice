package code_practice;

import java.util.Scanner;

public class JpmCompressNumber {

	public JpmCompressNumber() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scanner = new Scanner(System.in);
		String[] input = scanner.nextLine().split(" ");
		
//		System.out.println(input);
	
		scanner.close();
		StringBuilder sb = new StringBuilder();
		String temp = input[0];
		int count = 1;
		for(int i = 1; i <input.length; i++) {
			if(!input[i].equals(temp)) {
				sb.append(count);
				sb.append(" ");
				sb.append(temp);
				sb.append(" ");
				count = 1;
				temp = input[i];
			}
			else {
				count++;
				System.out.println("count " + count);

			}
			
		}
		sb.append(count);
		sb.append(" ");
		sb.append(temp);
		String output = sb.toString();
		System.out.println("output is " + output);
		
		//second method
		StringBuilder sb2 = new StringBuilder();
		int indexAns = 0;
		int index = 0;
//		char[] arr = input.toString().toCharArray();
		while(index < input.length) {
			String currNum = input[index];
			int cnt = 0;
			while(index < input.length && input[index].equals(currNum)) {
				index++;
				cnt++;
			}
			sb2.append(cnt + " ");
			sb2.append(currNum + " ");
			
		}
		System.out.println("output2 is " + sb2.toString());

	}
	
	
}
