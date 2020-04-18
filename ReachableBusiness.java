package code_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class ReachableBusiness {
	public Business a = new Business("A", new HashMap<Business, Integer>());
	public Business b = new Business("B", new HashMap<Business, Integer>());
	public Business c = new Business("C", new HashMap<Business, Integer>());
	public Business d = new Business("D", new HashMap<Business, Integer>());

	public ReachableBusiness() {
		a.nearby_business.put(b, 2);
		a.nearby_business.put(c, 4);
		b.nearby_business.put(a, 2);
		b.nearby_business.put(d, 5);
		c.nearby_business.put(a, 4);
	}

	private class Business {
		public String name;
		public HashMap<Business, Integer> nearby_business;

		public Business(String name, HashMap<Business, Integer> nearby_business) {
			this.name = name;
			this.nearby_business = nearby_business;
		}
	}

	public static void main(String[] args) {
		ReachableBusiness rbs = new ReachableBusiness();
		Business starting_business = rbs.a;

		int distance = 2;
		// A -B: 2; A-C: 3, reachable_distance=5，起始点A， 结果就是[[B],[C],[B,C]]
		List<String> rb = new ArrayList<>();
		HashMap<String, Integer> dis = new HashMap<>();
		dis.put(starting_business.name, 0);
		HashSet<String> visited = new HashSet<>();
		Queue<Business> q = new LinkedList<>();
		q.add(starting_business);
		// BFS to scan through all points in a graph

		while (!q.isEmpty()) {
			Business root = q.poll();
			visited.add(root.name);
			for (Business bs : root.nearby_business.keySet()) {
				if (!visited.contains(bs.name)) {
					

					q.add(bs);
					System.out.println("dis now:" + dis);
					System.out.println("bs name:" + bs.name);
					if (dis.containsKey(bs.name)) {
						System.out.println("root now:" + root.name);
						int newDis = dis.get(root.name) + root.nearby_business.get(bs);
						if (newDis < dis.get(bs.name)) {
							dis.put(bs.name, newDis);
						}
					}
					else {
						dis.put(bs.name, dis.get(root.name) + root.nearby_business.get(bs));
					}
				}
			}
		}
		System.out.println("dis:" + dis);
		for(String name:dis.keySet()) {
			if(dis.get(name) <= distance && !name.equals(starting_business.name)) {
				System.out.println("node:" + name);
			}
		}

	}

}
