package model;

import java.util.ArrayList;

public class Day {

    private ArrayList<Workout> workouts;
    private ArrayList<Food> foods;

    public Day(){

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
}
