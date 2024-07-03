package code_practice.ubs;

import java.util.ArrayList;
import java.util.List;

public class Weather {
    String place;
    Double temperature;

    public Weather(){

    }
    public Weather(String place, Double temperature){
        this.place = place;
        this.temperature = temperature;
    }

    public Double getTemperature(){
        return temperature;
    }
    public String getPlace(){
        return place;
    }

    public String toString(){
        return new StringBuffer(" Place : ")
                .append(this.place)
                .append(" Temperature : ")
                .append(this.temperature).toString();
    }
    interface Test{
        int aMethod(String s);
    }

    public static void main(String[] args){
        List<Weather> weatherList = new ArrayList<>();
        weatherList.add(new Weather("Sunny", 33.0));
        weatherList.add(new Weather("Rainy", 17.0));
        weatherList.add(new Weather("Cloudy", 23.0));
        weatherList.add(new Weather("Cold", 3.0));
        weatherList.add(new Weather("Hot", 37.0));
        weatherList.add(new Weather("Windy", 13.0));
        weatherList.add(new Weather("Snowy", 0.0));
        weatherList.add(new Weather("Freezing", -16.0));

        weatherList.stream().sorted((p1, p2)
    -> p1.getTemperature().compareTo(p2.getTemperature())).forEach(System.out::println);

        weatherList.stream().map(Weather::getTemperature).sorted(
                (p1, p2) -> p1.compareTo(p2)
        ).forEach(System.out::println);

        //Test a = a->a.length(); //wrong a is already defined
        Test b = (String s) -> 1;
//        Test s = "2" -> Integer.parseInt(s); //wrong
//        Test x = y -> {return y;}; //String can't be cast to int

        System.out.println(b.aMethod("test"));
    }
}
