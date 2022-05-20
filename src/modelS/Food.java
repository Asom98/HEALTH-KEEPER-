package modelS;

import java.util.Date;

public class Food {
    private String foodName;
    private int calories;

    private Date date;

    public Food(String foodName,int calories, Date date) {
        this.foodName = foodName;
        this.calories = calories;
        this.date = date;

    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
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
