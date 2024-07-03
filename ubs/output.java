package code_practice.ubs;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class output {
    public static int test(int n){
//        Stream.iterate(new int[]{0, 1},
//                x-> new int[]{x[1], x[0] + x[1]})
//                .limit(n)
//                .map(x ->x[0])
//                .collect(Collectors.toList()).forEach(System.out::println);


        int sum = Stream.iterate(new int[]{0, 1},
                        x-> new int[]{x[1], x[0] + x[1]})
                .limit(n)
                .map(x ->x[0])
                .collect(Collectors.toList())
                .stream()
                .distinct()
                .filter(i -> i % 2 == 0)
                .mapToInt(i->i)
                .sum();
        return sum;
    }
    public static void main(String[] args){
//        int sum = Stream.iterate(new int[]{0,1}, t->

        System.out.println(test(8));
        System.out.println(test(7));





    }
}
