package code_practice;

import java.util.Arrays;

public class ReorderLog {

	private static String[] reorderLogFiles(String[] logs) {
		String[] result = null;
		Arrays.sort(logs, (log1, log2)->{
			String[] split1 = log1.split(" ", 2);
			String[] split2 = log2.split(" ", 2);
			  boolean digit1 = Character.isDigit(split1[1].charAt(0));
	            boolean digit2 = Character.isDigit(split2[1].charAt(0));
	            
	            if(!digit1 && !digit2){
	                if(split1[1].compareTo(split2[1]) == 0){
	                    return split1[0].compareTo(split2[0]);
	                }
	                else{
	                    return split1[1].compareTo(split2[1]);
	                }
	                 
	            }
	            //compare digit 
	            return digit1 ? (digit2 ? 0 : 1 ) : -1;
			
		});
		
		
		return logs;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] logs = {"dig4 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"};
		
		String [] outputs = reorderLogFiles(logs);
		
		System.out.println(Arrays.toString(outputs));
	}

}
