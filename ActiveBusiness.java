package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ActiveBusiness {
    public List<Event> events;
    public int eventTypeAmount;
    public ActiveBusiness(){
        events = new ArrayList<>();
        eventTypeAmount = 4;
        events.add(new Event("ads", 7, 3));
        events.add(new Event("ads", 8, 2));
        events.add(new Event("ads", 5, 1));
        events.add(new Event("page_views", 11, 2));
        events.add(new Event("page_views", 12, 3));
        events.add(new Event("photo_views", 10, 3));
        events.add(new Event("reviews", 7, 2));
//        events.add(new Event("reviews", 8, 1));
//        events.add(new Event("ads", 8, 1));

    }
    private class Event{
        String type;
        int times;
        int biz_id;

        public Event(String type, int times, int biz_id) {
            this.type = type;
            this.times = times;
            this.biz_id = biz_id;
        }
    }
    public static void main(String[] args) {
		//first find avg of all events
    	ActiveBusiness ab = new ActiveBusiness();
    	Map<Integer, Integer[]> eventCount = new HashMap<Integer, Integer[]>();
    	
    	List<Event> events = ab.events;
    	System.out.println("events:" + events);
    	Double[] avg = {0.0,0.0,0.0,0.0};
    	Integer[] count = {0,0,0,0};
    	
    	for(Event evnt:events) {
    		if (evnt.type =="ads" ) {
    			if(!eventCount.containsKey(evnt.biz_id)) {
    				Integer[] temp = {0,0,0,0};
    				temp[0]=evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			else {
    				Integer[] temp = eventCount.get(evnt.biz_id);
    				temp[0] = evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			count[0]++;
    			avg[0] = (avg[0]*(count[0]-1)+evnt.times ) / count[0];
    			System.out.println("avg 0:" + avg[0]);
    		}
    		else if (evnt.type =="page_views" ) {
    			if(!eventCount.containsKey(evnt.biz_id)) {
    				Integer[] temp = {0,0,0,0};
    				temp[1]=evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			else {
    				Integer[] temp = eventCount.get(evnt.biz_id);
    				temp[1] = evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			count[1]++;
    			avg[1] = (avg[1]*(count[1]-1)+evnt.times ) / count[1];
    		}
    		else if (evnt.type =="photo_views" ) {
    			if(!eventCount.containsKey(evnt.biz_id)) {
    				Integer[] temp = {0,0,0,0};
    				temp[2]=evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			else {
    				Integer[] temp = eventCount.get(evnt.biz_id);
    				temp[2] = evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			count[2]++;
    			avg[2] = (avg[2]*(count[2]-1)+evnt.times ) / count[2];
    		}
    		else if (evnt.type =="reviews" ) {
    			if(!eventCount.containsKey(evnt.biz_id)) {
    				Integer[] temp = {0,0,0,0};
    				temp[3]=evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			else {
    				Integer[] temp = eventCount.get(evnt.biz_id);
    				temp[3] = evnt.times;
    				eventCount.put(evnt.biz_id,temp);
    			}
    			count[3]++;
    			avg[3] = (avg[3]*(count[3]-1)+evnt.times ) / count[3];
    		}
    		
    	}
		System.out.println("avg:" + Arrays.toString(avg));
		System.out.println("count:" + Arrays.toString(count));
		int cnt = 0;
		List<Integer> result = new ArrayList<Integer>();
		
    	for(Integer key : eventCount.keySet()) {
    		cnt=0;
//    		System.out.println("key:" + key);
//    		System.out.println("values:" + Arrays.toString(eventCount.get(key)));
    		for(int i = 0; i<avg.length; i++) {
    			if(eventCount.get(key)[i] >= avg[i] ) {
    				cnt++;
    			}
    		}
    		if(cnt >=2) {
    			result.add(key);
    		}
    	}
    	System.out.println("result:"+result);
	}
}