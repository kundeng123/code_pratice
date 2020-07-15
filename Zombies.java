package code_practice;

import java.util.LinkedList;
import java.util.Queue;

public class Zombies {

	public static int solution(int[][] grid) {
	    int[] dr = new int[]{-1,0,1,0};
	    int[] dc = new int[]{0,-1,0,1};
	    int row = grid.length;
        int col = grid[0].length;
        // * 时间复杂度：O(M*N)
        //* 空间复杂度：O(M*N)
        Queue<int[]> queue = new LinkedList<>();
        int human = 0;

        for(int i =0; i<row; i++){
            for(int j =0; j<col; j++){
                if(grid[i][j] == 1){
                    queue.offer(new int[]{i,j});
                }
                else if(grid[i][j] ==0){
                	human++;
                }
            }
        }
        if(human == 0) {
        	return 0;
        }
        int count = 0;
        while(!queue.isEmpty() && human > 0) {
        	count++;
        	int size = queue.size();
        	for(int i = 0; i<size; i++) {
        		int[] point = queue.poll();
        		for(int j = 0; j <4; j++) {
        			 int x = point[0] + dr[j];
                     int y = point[1] + dc[j];
                     if(x<0 || y<0 || x>=row ||y>=col
                       || grid[x][y] == 1){
                         continue;
                     }
                     grid[x][y] =1;
                     
                     queue.offer(new int[]{x,y});
                     human--;
        		}
        	}
        }
        return human == 0 ? count : -1;
	}
	public static void main(String[] args) {
		//Given a 2D grid, each cell is either a zombie 1 or a human 0. 
		//Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour. Find out how many hours does it take to infect all humans?
		int[][] grid = { { 0, 1, 1, 0, 1 }, { 0, 1, 0, 1, 0 }, { 0, 0, 0, 0, 1 }, { 0, 1, 0, 0, 0 } };
		System.out.println(solution(grid));
	}

}
