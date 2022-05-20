package modelS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;


class DayTest {
    /**
     * Testing:
     *
     * <ul>
     *   <li>{@link Day#Day(Date)}
     *   <li>{@link Day#setDate(Date)}
     *   <li>{@link Day#setFoods(ArrayList)}
     *   <li>{@link Day#setWorkouts(ArrayList)}
     * </ul>
     */
    @Test
    void testDay() {
        Day actualDay = new Day(null);
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant());

        actualDay.setDate(fromResult);

        // Food
        ArrayList<Food> foodList = new ArrayList<>();
        ArrayList<Food> foods = actualDay.getFoods();
        actualDay.setFoods(foodList);

        // Workout
        ArrayList<Workout> workoutList = new ArrayList<>();
        actualDay.setWorkouts(workoutList);
        ArrayList<Workout> workouts = actualDay.getWorkouts();

        // Asserts
        Assertions.assertSame(fromResult, actualDay.getDate());
        Assertions.assertSame(foodList, foods);
        Assertions.assertSame(workoutList, workouts);

        Assertions.assertEquals(foodList, workouts);
        Assertions.assertEquals(workouts, foods);
    }
}

