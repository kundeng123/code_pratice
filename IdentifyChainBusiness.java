package code_practice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class IdentifyChainBusiness {
	public List<Business> businesses;

	public IdentifyChainBusiness() {
		businesses = new ArrayList<>();
		businesses.add(new Business("Starbucks", "Seattle", "101"));
		businesses.add(new Business("Peets Coffee", "San Francisco", "102"));
		businesses.add(new Business("Whole foods", "Austin", "103"));
		businesses.add(new Business("Starbucks", "San Francisco", "104"));
		businesses.add(new Business("Peets Coffee", "Austin", "105"));
		businesses.add(new Business("Starbucks", "Austin", "106"));
		businesses.add(new Business("Whole foods", "Austin", "103"));
		businesses.add(new Business("Whole foods", "Austin", "107"));
	}

	public class Business {
		String name;
		String location;
		String id;

		public Business(String name, String location, String id) {
			this.name = name;
			this.location = location;
			this.id = id;
		}
	}

	public static class Chain {
		String name;
		int frequency;

		public Chain(String name, int frequency) {
			this.name = name;
			this.frequency = frequency;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IdentifyChainBusiness cb = new IdentifyChainBusiness();
		List<Business> businessList = cb.businesses;
		// Given a location, find all business in that location1.
		// 要求按出现频率进行降序排序；2. 如果频率相同的情况下， 需要按餐厅名的字母顺序的自然顺序输出。3. 需要注意的是相同的餐厅名和地点, 可能有不同的ID.
		// 输出需要保证频率统计的是unique的ID.
//		Chain cb = new Chain("",0);
		List<Chain> chains = new ArrayList<>();
		Set<String> businessSet = new HashSet<>();
		Map<String, Integer> businessMap = new HashMap<>();

		for (int i = 0; i < businessList.size(); i++) {
			if (!businessList.get(i).name.equals("") && !businessList.get(i).location.equals("")
					&& !businessList.get(i).id.equals("")) {
				StringBuilder sb = new StringBuilder();
				sb.append(businessList.get(i).name);
				sb.append("-");
				sb.append(businessList.get(i).location);
				sb.append("-");
				sb.append(businessList.get(i).id);
				if (!businessSet.contains(sb.toString())) {
					businessSet.add(sb.toString());
				}

			}
		}
		System.out.println(businessSet);
		for (String business : businessSet) {

			String[] strArray = business.split("-");
			String name = strArray[0];
			String location = strArray[1];
			String id = strArray[2];
			if (location.equals("Austin")) {
				businessMap.put(name, businessMap.getOrDefault(name, 0) + 1);
			}

		}
		for (Map.Entry<String, Integer> entry : businessMap.entrySet()) {
			String name = entry.getKey();
			Integer frequency = entry.getValue();

			chains.add(new Chain(name, frequency));
		}
		Collections.sort(chains, new Comparator<Chain>() {
			@Override
			public int compare(Chain o1, Chain o2) {
				if (o1.frequency > o2.frequency) {
					return -1;
				} else if (o1.frequency < o2.frequency) {
					return 1;
				} else {
					return o1.name.compareTo(o2.name);
				}
			}
		});
		for (Chain c : chains) {
			System.out.println("chain name:" + c.name);
			System.out.println("chain freq:" + c.frequency);

		}
	}

}
