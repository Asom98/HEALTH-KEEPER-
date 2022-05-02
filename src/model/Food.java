package model;

public class Food {

    public int getCalories() {
        return calories;
    }

    public void setCalories(int calories) {
        this.calories = calories;
    }

    private int calories;

    public Food(int calories) {
        this.calories = calories;
    }

}
