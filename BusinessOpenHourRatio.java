package code_practice;

import java.util.ArrayList;
import java.util.List;

public class BusinessOpenHourRatio {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] query = {0,12};
		List<Integer[]> openHours = new ArrayList<Integer[]>();
		openHours.add(new Integer[]{0,2});
		openHours.add(new Integer[] {10,24});
		//ratio should be 4/12 
		double result = 0.0;
		for(Integer[] hour : openHours) {
			int start = Math.max(query[0], hour[0]);
			int end = Math.min(query[1], hour[1]);
			if(end > start) {
				result += (double)(end - start) / (double)(query[1] - query[0]);
			}
		}
		System.out.println("result:" + result);
	}

}
