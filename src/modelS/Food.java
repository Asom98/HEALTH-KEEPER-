package modelS;

import java.util.Date;

public class Food {
    private String foodName;
    private int calories;

    public Food(String foodName,int calories) {
        this.foodName = foodName;
        this.calories = calories;

    }
    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    public String getFoodName() {
        return foodName;
    }
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }
    @Override
    public String toString() {
        return "Food{" + foodName + "}";
    }
}
