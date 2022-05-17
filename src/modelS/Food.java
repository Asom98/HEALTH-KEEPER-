package modelS;

import java.util.Date;

public class Food {
    private String foodName;
    private int calories;
    private Date foodDate;

    public Food(String foodName,int calories, Date foodDate) {
        this.foodName = foodName;
        this.calories = calories;
        this.foodDate = foodDate;
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

    public Date getFoodDate() {
        return foodDate;
    }

    public void setFoodDate(Date foodDate) {
        this.foodDate = foodDate;
    }




}
