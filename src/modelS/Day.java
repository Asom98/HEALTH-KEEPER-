package modelS;

import java.util.ArrayList;
import java.util.Date;

public class Day {
    private Date date;
    private ArrayList<Workout> workouts;
    private ArrayList<Food> foods;

    public Day(Date date){
        this.date = date;
    }

    public ArrayList<Workout> getWorkouts() {
        return workouts;
    }

    public void setWorkouts(ArrayList<Workout> workouts) {
        this.workouts = workouts;
    }

    public ArrayList<Food> getFoods() {
        return foods;
    }

    public void setFoods(ArrayList<Food> foods) {
        this.foods = foods;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
