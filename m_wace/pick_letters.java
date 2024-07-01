package code_practice.m_wace;

import java.util.HashMap;
import java.util.Map;

public class pick_letters {
    /*
    example s = [a,aa,ab,bb,bc,bd] k=1 output = 2 -> pick 'a' to build 'a','aa'
     */

    public int solution(String[] arr, int k){
        Map<String, Integer> map = new HashMap<>();
        int result = 0;
        for(String item : arr){
            String rep = getRep(item);
            if(rep.length() <= k) {
                map.put(rep, map.getOrDefault(rep, 0) + 1);
            }
            for(String key : map.keySet()){
//            System.out.println(key + " " + map.get(key));
                result = Math.max(result, map.get(key));
            }
        }

        return result;
    }
    public String getRep(String input){
        int[] cnt = new int[26];
        for(char c : input.toCharArray()){
            cnt[c-'a'] = 1;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i <26; i++){
            if(cnt[i] != 0){
                sb.append((char) (i + 97));
            }
        }
        return sb.toString();
    }
    public static void main(String args[]) {
        String[] input = new String[]{"a", "aa", "ab", "bb", "bc", "bd"};
        int k = 2;
        pick_letters pick_letters = new pick_letters();
        int result = pick_letters.solution(input, k);
        System.out.println(result);

        input = new String[]{"adf", "jjbh", "jcgj", "eijj", "adf"};
        k = 3;
        result = pick_letters.solution(input, k);
        System.out.println(result);

        input = new String[]{"abcd", "efgh"};
        k = 3;
        result = pick_letters.solution(input, k);
        System.out.println(result);

        input = new String[]{"bc", "edf", "fde", "dge", "abcd"};
        //WRONG ANSWER!!! NEED to CHECK
        k = 4;
        result = pick_letters.solution(input, k);
        System.out.println(result);
    }
}
