package modelS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Date;

class FoodTest {
    @Test
    public void testGetCalories (){
        Food food = new Food("meat", 500, new Date(2022-05-20));
        Assertions.assertEquals(500, food.getCalories());
    }

    @Test
    public void testDate (){
        Date date = new Date(2020, 05, 20);
        Assertions.assertEquals(2020-05-20, date.getDate());
    }

    @Test
    public void testGetFoodName (){
        Food food = new Food("meat", 130, new Date(2022-02-02));
        Assertions.assertEquals("meat", food.getFoodName());

    }
}