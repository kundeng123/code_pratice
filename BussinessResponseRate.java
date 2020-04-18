package code_practice;

import java.util.HashMap;
import java.util.Map;

public class BussinessResponseRate {
	public MyMessage[] messages;
    private int[] sender = {1, 42, 2, 2, 3, 3};
    private int[] recipient = {42, 1, 42, 42, 88, 42};
    private int[] con = {1, 1, 2, 2, 3, 4};

    public BussinessResponseRate() {
        messages = new MyMessage[6];
        for (int i = 0; i < 6; i++) {
            messages[i] = new MyMessage(sender[i], recipient[i], con[i]);
        }
    }

    private class MyMessage {
        public int sender;
        public int recipient;
        public int conversation_id;

        public MyMessage(int s, int r, int c) {
            sender = s;
            recipient = r;
            conversation_id = c;
        }
    }
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int bizOwner = 42;
		BussinessResponseRate br = new BussinessResponseRate();
		MyMessage[] messages = br.messages;
		
		//find return rate for bizOwner 1
		Map<Integer, Integer> sender = new HashMap<Integer, Integer>();
		Map<Integer, Integer> received = new HashMap<Integer, Integer>();
		
		for(MyMessage msg : messages) {
			if(msg.sender == bizOwner) {
				sender.put(msg.conversation_id, sender.getOrDefault(msg.conversation_id, msg.recipient));
			}
			if(msg.recipient == bizOwner) {
				received.put(msg.conversation_id, sender.getOrDefault(msg.conversation_id, msg.sender));
			}
		}
		System.out.println(sender);
		System.out.println(received);
		double res=0;
		 for (Integer i: sender.keySet()) {
	            if (received.containsKey(i)) {
	                if (received.get(i).equals(sender.get(i))) {
	                    res++;
	                }
	            }
	        }
		 
		 res = res / received.size() * 100;
	     int result = (int)res;
	}
	/*
	 *   public int bussiness_resonsiveness_rate(int biz_owner, MyMessage[] messages) {
        double res = 0;
        HashMap<Integer, Integer> receive = new HashMap<>();
        HashMap<Integer, Integer> response = new HashMap<>();
        for (int i = 0; i < messages.length; i++) {
            if (messages[i].sender == biz_owner) {
                if (!response.containsKey(messages[i].conversation_id)) {
                    response.put(messages[i].conversation_id, messages[i].recipient);
                }
            }
            if (messages[i].recipient == biz_owner) {
                if (!receive.containsKey(messages[i].conversation_id)) {
                    receive.put(messages[i].conversation_id, messages[i].sender);
                }
            }
        }
        for (Integer i: receive.keySet()) {
            if (response.containsKey(i)) {
                if (response.get(i).equals(receive.get(i))) {
                    res++;
                }
            }
        }
        res = res / receive.size() * 100;
        return (int)res;
    }
	 */

}
