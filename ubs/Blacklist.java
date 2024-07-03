package code_practice.ubs;

import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.StreamSupport;

public class Blacklist {
    public static String hello(String p){
        p = p.replace(".", "\\.");
        p = p.replace("*", ".*");
        return "^" + p + "$";
    }
    public static boolean fun(String ip, List<Pattern> pattern){
        for(Pattern p : pattern){
            if(p.matcher(ip).matches()){
                return true;
            }
        }
        return false;
    }

    public static List<Integer> validateRequest(List<String> blacklisted_ips, List<String> requests){
        List<Pattern> patternList = new ArrayList<>();
        for(String ip : blacklisted_ips){
            patternList.add(Pattern.compile(hello(ip)));
        }
        Map<String, Deque<Integer>> map = new HashMap<>();
        List<Integer> result = new ArrayList<>();
        for(int i = 0; i<requests.size(); i++){
            String ip = requests.get(i);
            map.putIfAbsent(ip, new LinkedList<>());
            Deque<Integer> deque = map.get(ip);
            if(!deque.isEmpty() && deque.peekFirst() <= i-5){
                deque.pollFirst();
            }
            boolean match = fun(ip, patternList);
            if(!match){
                if(deque.size() >= 2){
                    match = true;
                }
            }
            result.add(match ? 1: 0);
            if(!match){
                deque.addLast(i);
            }

        }
        return result;
    }

    public static void main(String[] args){
        List<String> blackListIp = new ArrayList<>();
        blackListIp.add("*111.*");
        blackListIp.add("123.*");
        blackListIp.add("34.*");

        List<String> request = new ArrayList<>();
        request.add("123.1.23.34");
        request.add("121.1.23.34");
        request.add("121.1.23.34");
        request.add("34.1.23.34");
        request.add("121.1.23.34");
        request.add("12.1.23.34");
        request.add("121.1.23.34");

        List<Integer> result = validateRequest(blackListIp, request);
        result.stream().forEach(System.out::println);
    }
}
