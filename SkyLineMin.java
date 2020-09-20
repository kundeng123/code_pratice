package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.PriorityQueue;

public class SkyLineMin {

	private class Interval{
		public int start;
		public int end;
		public int price;
		public Interval(int start, int end, int price) {
			this.start = start;
			this.end = end;
			this.price = price;
		}
		public int getStart() {
			return this.start;
		}
		public int getEnd() {
			return this.end;
		}
		public int getPrice() {
			return this.price;
		}
		
	@Override
	public boolean equals(Object a) {
		System.out.println("here");
		Interval ab = (Interval) a;
		if(this == a) {
			return true;
		}
		if(this.start == ab.getStart() && this.end == ab.getEnd() && this.price == ab.getPrice()) {
			return true;
		}
		return false;
	}
	@Override
	public int hashCode() {

	    return Objects.hash(this.start, this.end, this.price);
	}
		
	}
	public SkyLineMin() {
		// TODO Auto-generated constructor stub
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Solution solution = new Solution();
		//[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]
//		int[][] input =  new int[][]{
//			  { 2,9,10 },
//			  { 3,7,15 },
//			  { 5,12,12 },
//			  { 15,20,10 },
//			  { 19,24,8 }
//			};
			int[][] input =  new int[][]{
				  {1,9,10},
				  {2,6,8}
				};
			List<List<Integer>> result = solution.getSkyline(input);
			System.out.println(result);
			SkyLineMin min = new SkyLineMin();
			
			Interval int1 = min.new Interval(1,2,3);
			Interval int2 = min.new Interval(2,5,6);
			
			Interval int3 = min.new Interval(1,2,3);
			Interval int4 = min.new Interval(2,5,6);

			List<Interval> l1 = new ArrayList<>(Arrays.asList(int1, int2));
			List<Interval> l2 = new ArrayList<>(Arrays.asList(int3,int4));
			System.out.println(l1.equals(l2));
			
	}

}
class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        /*
        for position in sorted(all start points and all end points)
       if this position is a start point
              add its height
       else if this position is a end point
              delete its height
       compare current max height with previous max height, if different, add
       current position together with this new max height to our result, at the
       same time, update previous max height to current max height;
       O(n^2)time This is O(n^2) because removal in a PQ is O(n), O(n) space
       */
        List<List<Integer>> res = new ArrayList<>();
        List<int[]> buildLines = new ArrayList<>();
        for (int[] points : buildings){ // L, R, H
            buildLines.add(new int[]{points[0], -points[2]}); // L, -H
            buildLines.add(new int[]{points[1], points[2]}); // R, H
        }
        Collections.sort(buildLines, (a,b)->{
            if(a[0]!=b[0]){return a[0]-b[0];}
            else{return a[1]-b[1];}
        });
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>();
        
        int preHeighest = - buildLines.get(0)[1];
        int prevL = buildLines.get(0)[0];
        //maxHeap.add(preHeighest); // initial default height = 0
        for(int[] points: buildLines){
            if (points[1] < 0){
                maxHeap.add(-points[1]); // this is a start of a new building, add its height to the maxHeap
            }else{
                maxHeap.remove(points[1]); //this is an end of a building, remove its height from the maxHeap
            }
            int curHeight = 0;
            if(!maxHeap.isEmpty() )
            	curHeight = maxHeap.peek(); //current maxHeap's top is current height
            System.out.println("current height:" + curHeight);
            if (curHeight != preHeighest){ //there is a change of the height
                res.add(Arrays.asList(prevL, points[0], preHeighest)); //add L and current height to the result array
                preHeighest = curHeight; // update preHeighest by the new height
                prevL = points[0];
            }
        }
        return res;
    }
}