package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CriticalConnectionsPoints {

	//using Tarjan algorithm
	//Time complexity: called once for each node,, for consider each edge at 
	//most oince. so O(V + E)
	//Space complexity: O(N) //number of nodes
	private static int time = 0;
	public static List<Integer> solution(int n, List<Integer[]> edges){
		List<Integer> result = new ArrayList<>();
		int[] discover = new int[n];
		int[] lowlink = new int[n];
		int[] parent = new int[n];
		List<Integer>[] graph = new ArrayList[n];
		//initialize all discover time to -1
		Arrays.fill(discover, -1);
		Arrays.fill(parent, -1);
		//build graph
		for(int i = 0; i<n; i++) {
			graph[i] = new ArrayList<>();
		}
		for(int i = 0; i<edges.size(); i++) {
			//System.out.println(Arrays.toString(edges.get(i)));
			int from = edges.get(i)[0] -1 ;
			int to = edges.get(i)[1] -1 ;
			graph[from].add(to);
			graph[to].add(from);
		}
//		for(int i = 0; i <graph.length; i++){
//            System.out.println(graph[i]);
//        }
		
		for(int i = 0; i <n; i++) {
			if(discover[i] == -1) {
				dfs(i, i, lowlink, discover, graph, result, parent);
			}
		}
		
		System.out.println(result);
		
		return result;
	}
	public static void dfs(int prev, int u, int[] lowlink, int[] discover, 
			List<Integer>[] graph, List<Integer> result, int[] parent) {
		discover[u] = lowlink[u] = ++time;
		int childrenCount = 0;
		for(int i = 0; i<graph[u].size(); i++) {
			int v = graph[u].get(i); //get connected node from u
			
			if( v == prev) {
				continue;
			}
			//new node
			if(discover[v] == -1) {
				childrenCount++;
				parent[v] = u;
				dfs(u, v, lowlink, discover, graph, result, parent);
				//when call back
				lowlink[u] = Math.min(lowlink[u], lowlink[v]);
				System.out.println("current at point:" + u);
				System.out.println("parent at call back" + Arrays.toString(parent));

				if(discover[u] < lowlink[v]) {
					System.out.println("bridge - current at point:" + u);
					System.out.println("bridge - current # of children:" + childrenCount);
					result.add(u+1);
				}
				else if(discover[u] == lowlink[v] && parent[u] != -1 ) {
					System.out.println("current at point:" + u);
					System.out.println("current # of children:" + childrenCount);
					System.out.println("parent of current point:" + parent[u]);

					result.add(u+1);
				}
			}
			else {
				lowlink[u] = Math.min(lowlink[u], discover[v]); 
			}
		}
	}
	public static void main(String[] args) {

		//input int n number of nodes, list of int for edges
		//Input: n = 5, edges = [[1, 2], [1, 3], [3, 4], [1, 4], [4, 5]]
		int n = 9;
		List<Integer[]> edges = new ArrayList<>();
		edges.add(new Integer[] {1,2});
		edges.add(new Integer[] {1,3});
		edges.add(new Integer[] {2,3});
		edges.add(new Integer[] {3,4});
		edges.add(new Integer[] {3,6});
		edges.add(new Integer[] {4,5});
		edges.add(new Integer[] {6,7});
		edges.add(new Integer[] {6,9});
		edges.add(new Integer[] {7,8});
		edges.add(new Integer[] {8,9});
//		int n = 7;
//		List<Integer[]> edges = new ArrayList<>();
//		edges.add(new Integer[] {0,1});
//		edges.add(new Integer[] {0,2});
//		edges.add(new Integer[] {1,3});
//		edges.add(new Integer[] {2,3});
//		edges.add(new Integer[] {2,5});
//		edges.add(new Integer[] {5,6});
//		edges.add(new Integer[] {3,4});
//		edges.add(new Integer[] {6,9});
//		edges.add(new Integer[] {7,8});
//		edges.add(new Integer[] {8,9});
		
		//if no bridge 
//		n=5;
//		edges = new ArrayList<>();
//		edges.add(new Integer[] {0,2});
//		edges.add(new Integer[] {0,1});
//		edges.add(new Integer[] {1,2});
//		edges.add(new Integer[] {2,3});
//		edges.add(new Integer[] {3,4});
//		edges.add(new Integer[] {2,4});
		//where there's a cycle, id(e.from) = low(e.to)
		//and outgoing edges for that from node is > 1
		
		//if cycle only
//		n=3;
//		edges = new ArrayList<>();
//		edges.add(new Integer[] {0,2});
//		edges.add(new Integer[] {0,1});
//		edges.add(new Integer[] {1,2});
//		edges.add(new Integer[] {2,3});
//		edges.add(new Integer[] {3,4});
//		edges.add(new Integer[] {2,4});
		solution(n, edges);
	}

}
