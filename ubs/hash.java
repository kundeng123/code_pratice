package code_practice.ubs;

import java.util.HashMap;
import java.util.Map;

public class hash {
    public static int gcd(int a, int b) {
        if (a == 0)
            return b;

        while (b != 0) {
            if (a > b)
                a = a - b;
            else
                b = b - a;
        }

        return a;
    }

    public static void main(String[] args){
        int N = 7;
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < 20; i++){
            int key = gcd(i, i+1) % N;
//            int key = (i * i) % N;
            System.out.println(key);
            map.put(key, map.getOrDefault(key, 0) + 1);
        }
        for(Map.Entry entry : map.entrySet()){
            System.out.println(entry.getKey() + " " + entry.getValue());
        }


    }
}
