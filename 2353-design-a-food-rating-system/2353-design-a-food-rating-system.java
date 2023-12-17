class FoodRatings {
    Map<String, String> foodToCuisine;
    Map<String, Integer> foodToRating;
    Map<String, TreeMap<Integer, Integer>> cuisineToRatings;
    Map<Integer, TreeMap<String, TreeSet<String>>> ratingToCuisineAndFood;
    public FoodRatings(String[] foods, String[] cuisines, int[] ratings) {
        foodToCuisine = new HashMap();
        foodToRating = new HashMap();
        cuisineToRatings = new HashMap();
        ratingToCuisineAndFood = new HashMap();
        int n = foods.length;
        for (int i=0; i<n; i++) {
            foodToCuisine.put(foods[i], cuisines[i]);
            foodToRating.put(foods[i], ratings[i]);
            cuisineToRatings.putIfAbsent(cuisines[i], new TreeMap());
            TreeMap<Integer, Integer> ratingCntMap = cuisineToRatings.get(cuisines[i]);
            ratingCntMap.put(ratings[i], ratingCntMap.getOrDefault(ratings[i], 0)+1);
            ratingToCuisineAndFood.putIfAbsent(ratings[i], new TreeMap());
            ratingToCuisineAndFood.get(ratings[i]).putIfAbsent(cuisines[i], new TreeSet());
            ratingToCuisineAndFood.get(ratings[i]).get(cuisines[i]).add(foods[i]);
        }
    }
    
    public void changeRating(String food, int newRating) {
        String cuisine = foodToCuisine.get(food);
        Integer rating = foodToRating.get(food);
        int original = cuisineToRatings.get(cuisine).getOrDefault(rating, 0);
        cuisineToRatings.get(cuisine).put(rating, original-1);
        if (cuisineToRatings.get(cuisine).get(rating) == 0) {
            cuisineToRatings.get(cuisine).remove(rating);
        }
        ratingToCuisineAndFood.get(rating).get(cuisine).remove(food);
        foodToRating.remove(food);
        foodToRating.put(food, newRating);
        original = cuisineToRatings.get(cuisine).getOrDefault(newRating, 0);
        cuisineToRatings.get(cuisine).put(newRating, original+1);
        ratingToCuisineAndFood.putIfAbsent(newRating, new TreeMap());
        ratingToCuisineAndFood.get(newRating).putIfAbsent(cuisine, new TreeSet());
        ratingToCuisineAndFood.get(newRating).get(cuisine).add(food);
    }
    
    public String highestRated(String cuisine) {
        // System.out.println(String.format("highestRated(%s)", cuisine));
        TreeMap<Integer, Integer> ratings = cuisineToRatings.get(cuisine);
        // System.out.println(String.format("ratings: %s", ratings));
        Integer highest = ratings.lastKey();
        // System.out.println(String.format("highest: %d", highest));
        TreeSet<String> foods = ratingToCuisineAndFood.get(highest).get(cuisine);
        // System.out.println(String.format("foods: %s", foods));
        return foods.first();
    }
}

/**
 * Your FoodRatings object will be instantiated and called as such:
 * FoodRatings obj = new FoodRatings(foods, cuisines, ratings);
 * obj.changeRating(food,newRating);
 * String param_2 = obj.highestRated(cuisine);
 */

/*

{foodname}: {cuisine}
{cuisine} : [ratings...]
{ratings} : [foodnames...]
*/

/*
["FoodRatings","changeRating","highestRated","changeRating","changeRating","changeRating","highestRated","highestRated"]
[
    [
        ["emgqdbo","jmvfxjohq","qnvseohnoe","yhptazyko","ocqmvmwjq"],
        ["snaxol","snaxol","snaxol","fajbervsj","fajbervsj"],
        [2,6,18,6,5]
    ],
    ["qnvseohnoe",11],
    ["fajbervsj"],
    ["emgqdbo",3],
    ["jmvfxjohq",9],
    ["emgqdbo",14],
    ["fajbervsj"],
    ["snaxol"]
]
*/