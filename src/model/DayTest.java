package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;




class DayTest {

    Day day = new Day();

    @Test
    public void testWorkoutArrayInit(){
        Assertions.assertTrue(day.getWorkouts().isEmpty());
        Assertions.assertEquals(0, day.getWorkouts().size());
    }


    @Test
    public void testWorkoutsArrayInsert(){
        Assertions.assertEquals(day.getWorkouts().size(), 2);
        day.getWorkouts().add(1, "Cardio");
        Assertions.assertEquals(day.getWorkouts().size(), 3);
        Assertions.assertEquals(day.getWorkouts().get(1), "Cardio");
    }

    @Test
    public void testWorkoutArrayReplace(){
        Assertions.assertEquals(day.getWorkouts().size(), 3);
        day.getWorkouts().set(1, "Gym");
        Assertions.assertEquals(day.getWorkouts().size(),3);
        Assertions.assertEquals(day.getWorkouts().get(1), "Gym");

    }
    @Test
    public void testFoodArrayInit(){
        Assertions.assertTrue(day.getFoods().isEmpty());
        Assertions.assertTrue(day.getFoods().size() == 0);
    }

    @Test
    public void testFoodArrayInsert(){
        Assertions.assertEquals(day.getFoods().size(), 0);
        day.getWorkouts().add(1, "Smoothie");
        Assertions.assertEquals(day.getWorkouts().size(), 1);
        Assertions.assertEquals(day.getWorkouts().get(1), "Smoothie");

    }

    @Test
    public void testFoodArrayReplace() {
        Assertions.assertEquals(day.getFoods().size(), 3);
        day.getFoods().set(1, "Gym");
        Assertions.assertEquals(day.getFoods().size(), 3);
        Assertions.assertEquals(day.getFoods().get(1), "Gym");
    }


}