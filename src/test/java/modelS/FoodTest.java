package modelS;

import  org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


class FoodTest {
    /**
     * Testing:
     *
     * <ul>
     *   <li>{@link Food#Food(String, int, Date)}
     *   <li>{@link Food#setCalories(int)}
     *   <li>{@link Food#setDate(Date)}
     *   <li>{@link Food#setFoodName(String)}
     * </ul>
     */
    @Test
    void testFood() {

        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Food actualFood = new Food("Food Name", 1, Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

        // Getters and setters
        actualFood.setCalories(1);
        actualFood.setDate(fromResult);
        actualFood.setFoodName("Food Name");

        // Assert
        Assertions.assertEquals(1, actualFood.getCalories());
        Assertions.assertSame(fromResult, actualFood.getDate());
        Assertions.assertEquals("Food Name", actualFood.getFoodName());
    }
}

