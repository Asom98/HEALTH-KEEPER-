package model;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class FoodTest {
    @Test
    public void testCalories (){
        Food food = new Food(500);
        Assertions.assertEquals(500, food.getCalories());
    }





}