package code_practice;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class LogIngestion {

	public static class User {
		int id;
		boolean opt;

		public User(int id, boolean opt) {
			this.id = id;
			this.opt = opt;
		}
	}

	public static class Log {
		int id;
		String action;

		public Log(int id, String action) {
			this.id = id;
			this.action = action;
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		User user1 = new User(1, false);
		User user2 = new User(19, true);
		User user3 = new User(4, true);
		User user4 = new User(54, false);
		List<User> users = new ArrayList<User>();
		users.add(user1);
		users.add(user2);
		users.add(user3);
		users.add(user4);

		Log l1 = new Log(19, "opt_out");
		Log l2 = new Log(1, "opt_in");
		Log l3 = new Log(71, "opt_in");
		Log l4 = new Log(19, "opt_in");
		Log l5 = new Log(19, "opt_out");
		List<Log> logs = new ArrayList<Log>();
		logs.add(l1);
		logs.add(l2);
		logs.add(l3);
		logs.add(l4);
		logs.add(l5);

		// return list of ids that changed
		Map<Integer, Boolean> updatedUser = new HashMap<Integer, Boolean>();
		Map<Integer, Boolean> oriUser = new HashMap<Integer, Boolean>();

		for (User user : users) {
			oriUser.put(user.id, user.opt);
		}

		List<Integer> result = new ArrayList<Integer>();
		Set<Integer> logValid = new HashSet<Integer>();
		for (Log log : logs) {
			boolean exist = false;
			for (User user : users) {
				if (user.id == log.id) {
					exist = true;

					if (log.action.equalsIgnoreCase("opt_out") && user.opt == true) {
//						User temp = new User(user.id,false);
						user.opt = false;
						updatedUser.put(user.id, false);

					} else if (log.action.equalsIgnoreCase("opt_in") && user.opt == false) {
//						User temp = new User(user.id,true);
						user.opt = true;
						updatedUser.put(user.id, true);

					}
				}

			}
			if (!exist) {
				logValid.add(log.id);
			}

		}
		for (Integer id : updatedUser.keySet()) {

			if (oriUser.get(id) != updatedUser.get(id)) {
				result.add(id);
			}

		}
		for (Integer id : logValid) {
			result.add(id);
		}

		System.out.println("logsValid:" + logValid);
		System.out.println("updatedUser:" + updatedUser);
		System.out.println("oriUser:" + oriUser);
		System.out.println("result:" + result);

	}

}
