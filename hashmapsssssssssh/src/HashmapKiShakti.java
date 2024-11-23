import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HashmapKiShakti {
    public static void main(String[] args) {
        List<Food> foodList = new ArrayList<>();
        foodList.add(new Food("R001", "F001"));
        foodList.add(new Food("R002", "F003"));
        foodList.add(new Food("R003", "F003"));
        foodList.add(new Food("R004", "F004"));
        foodList.add(new Food("R005", "F001"));

        Map<String, String> stringStringMap = filterList(foodList);
    }

    public static Map<String, String> filterList(List<Food> paramList){
        Map<String, Map<String, Integer>> firstMap = new HashMap<>();
        Map<String, String> resultMap = new HashMap<>();

        // Most ordered food(foodId) from restaurant(restaurantId)
        for (Food food : paramList) {
            String restaurantId = food.getRestaurantId();
            String foodId = food.getFoodId();
            firstMap.computeIfAbsent(restaurantId, k -> new HashMap<>())
                    .compute(foodId, (k, v) -> v == null ? 1 : v + 1);
        }

        for(Map.Entry<String, Map<String, Integer>> entry : firstMap.entrySet()){
            String restaurantId = entry.getKey();
            Map<String, Integer> restaurantMap = entry.getValue();

            String mostOrderFood = restaurantMap.entrySet().stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey)
                    .orElse(null);
            resultMap.put(restaurantId, mostOrderFood);
        }
        return resultMap;
    }
}
