package code_practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

public class UniqueMeals {
	 private static class Meal {
	        String name;
	        String[] ingredients;

	        public Meal(String n, String[] ingredients) {
	            this.name = n;
	            this.ingredients = ingredients;
	        }
	    }

	 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		UniqueMeals um = new UniqueMeals();
		
		Meal m1 = new Meal("b1", new String[]{"lettuce", "tomotao", "cheese","milk"});
		Meal m2 = new Meal("b2", new String[]{"lettuce", "tomotao", "cheese"});
		Meal m3 = new Meal("a1", new String[]{"lettuce", "tomotao"});
		Meal m4 = new Meal("a2", new String[]{"tomotao", "lettuce"});
		Meal m5 = new Meal("b1", new String[]{"tomotao", "lettuce","milk"});
		//unique meals are 3

		List<Meal> meals = new ArrayList<Meal>();
		meals.add(m1);
		meals.add(m2);
		meals.add(m3);
		meals.add(m4);
		meals.add(m5);
		HashSet<String> uniqueMeal = new HashSet<String>();
		for(Meal meal:meals) {
			String[] temp = meal.ingredients;
			Collections.sort(Arrays.asList(temp));
			System.out.println("temp:" + Arrays.toString(temp));
			uniqueMeal.add(Arrays.toString(temp));
		}

		System.out.println("unique:" + uniqueMeal);
	}

}
