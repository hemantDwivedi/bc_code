public class Food {
    private String restaurantId;
    private String foodId;

    // Constructor, Getter and Setter
    public Food(String restaurantId, String foodId) {
        this.restaurantId = restaurantId;
        this.foodId = foodId;
    }
    public String getRestaurantId() { return restaurantId; }
    public String getFoodId() { return foodId; }
}
