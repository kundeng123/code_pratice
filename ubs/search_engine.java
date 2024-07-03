package code_practice.ubs;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class search_engine {
    public static List<List<String>> getProducts(List<String> input, String search){
        List<List<String>> result = new ArrayList<>();
        Collections.sort(input);
        StringBuilder sb =new StringBuilder();

        for(char c : search.toCharArray()){
            sb.append(c);
            List<String> temp = new ArrayList<>();
            for(String item : input){
                if(item.startsWith(sb.toString())){
                    temp.add(item);
                }
            }
            result.add(temp.subList(0, Math.min(3, temp.size())));
        }

        return result;
    }

    public static void main(String[] args){
        List<String> products = new ArrayList<>();
        products.add("abdd");
        products.add("abdc");
        products.add("abaa");
        products.add("acbd");

        String searchWord = "abdc";
        List<List<String>> result = getProducts(products, searchWord);
        result.stream().forEach(x -> System.out.println(x));
    }
}
