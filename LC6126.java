package fakru.leetcode;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class LC6126 {

  public static void main(String[] args) {


    String[] foods = {"emgqdbo", "jmvfxjohq", "qnvseohnoe", "yhptazyko", "ocqmvmwjq"};
    String[] cuisines = {"snaxol", "snaxol", "snaxol", "fajbervsj", "fajbervsj"};
    int[] ratings = {2, 6, 18, 6, 5};
    FoodRatings foodRatings = new FoodRatings(foods, cuisines, ratings);
    foodRatings.changeRating("qnvseohnoe", 11);
    foodRatings.changeRating("emgqdbo", 3);
    foodRatings.changeRating("jmvfxjohq", 9);
    foodRatings.changeRating("emgqdbo", 14);
    System.out.println(foodRatings.highestRated("snaxol"));
  }
}

class Food {

  String name;
  String cuisine;
  int rating;

  Food(String name, String cuisine, int rating) {
    this.name = name;
    this.rating = rating;
    this.cuisine = cuisine;
  }
}

class FoodRatings {

  Map<String, PriorityQueue<Food>> map;
  Map<String, Food> foodCuisine;

  public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
    foodCuisine = new HashMap<>();
    map = new HashMap<>();
    for (int i = 0; i < foods.length; ++i) {
      map.computeIfAbsent(cuisines[i], x -> new PriorityQueue<>(
          (f1, f2) -> f1.rating != f2.rating ? f2.rating - f1.rating : f1.name.compareTo(f2.name))
      );
      Food food = new Food(foods[i], cuisines[i], ratings[i]);
      foodCuisine.put(foods[i], food);
      map.get(cuisines[i]).offer(food);
    }
  }

  public void changeRating(String food, int newRating) {
    Food f = foodCuisine.get(food);
    PriorityQueue<Food> foods = map.get(f.cuisine);
    foods.remove(f);
    f.rating = newRating;
    foods.offer(f);
  }

  public String highestRated(String cuisine) {
    return map.get(cuisine).peek().name;
  }
}
