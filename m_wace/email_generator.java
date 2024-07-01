package code_practice.m_wace;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class email_generator {
    //first.last(trunc to 8)@company.com
    private String generator(String input, String compayName){
        List<String> result = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();

        String[] names = input.split(";");
        for(String name : names){
            name =name.trim();
            String first = name.split(" ")[0];

            System.out.println("first " + first);
            String last = name.substring(name.lastIndexOf(' ') + 1);
            last = last.replace("-", "");
            last = last.substring(0, Math.min(8, last.length()));
            System.out.println("last "  + last);
            map.put(first + "." + last, map.getOrDefault(first + "." + last, 0) + 1);
            int cnt = map.get(first + "." + last);
            String email = "";
            if(cnt > 1){
                email = " <" + first + "." + last + cnt + "@" + compayName + ".com>";
            }
            else{
                email = " <" + first + "." + last + "@" + compayName + ".com>";
            }
            result.add(name + " " + email.toLowerCase());
        }
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            System.out.println(entry.getKey() + ", value : " + entry.getValue());
        }
//        result.stream().forEach(x -> System.out.println(x));
        return String.join("; ", result);
    }
    public static void main(String args[]){
        String input = "John Doe; Peter Benjamin Parker; Mary Jane Watson-Parker; John Elvis Doe; " +
                "John Evan Doe; Jane Doe; Peter Brain Parker";
        System.out.println("input: " + input);

        email_generator generator = new email_generator();
        String result = generator.generator(input, "example");
        System.out.println("result: " + result);

    }

}

