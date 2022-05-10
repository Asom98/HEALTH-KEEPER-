package modelS;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


class DayTest {

    Day day = new Day();

    @Test
    public void testWorkoutInsert() {
        assertEquals(day.getWorkouts().size(), day.getWorkouts().size());
        day.getWorkouts().add(0, new Workout(60,true));
        assertEquals(day.getWorkouts().size(), day.getWorkouts().size());
        assertEquals(day.getWorkouts().get(0), new Workout(60, true));
    }

    @Test
    public void testWorkoutReplace() {
        assertEquals(day.getWorkouts().size(), day.getWorkouts().size());
        day.getWorkouts().set(0, new Workout(90, false));
        assertEquals(day.getWorkouts().size(), day.getWorkouts().size());
        assertEquals(day.getWorkouts().get(0), new Workout(90, false));
    }
    @Test
    public void testWorkoutRemove() {
        assertEquals(day.getWorkouts().size(), day.getWorkouts().size());
        day.getWorkouts().remove(0);
        assertEquals(day.getWorkouts().size(), day.getWorkouts().size());
    }

    @Test
    public void testFoodInsert() {
        assertEquals(day.getFoods().size(), day.getFoods().size());
        day.getFoods().add(0, new Food(500));
        assertEquals(day.getFoods().size(), day.getFoods().size());
        assertEquals(day.getFoods().get(0), new Food(500));
    }

    @Test
    public void testFoodReplace() {
        assertEquals(day.getFoods().size(), day.getFoods().size());
        day.getFoods().set(0, new Food(1200));
        assertEquals(day.getFoods().size(), day.getFoods().size());
        assertEquals(day.getFoods().get(0), new Food(1200));
    }
    @Test
    public void testFoodRemove() {
        assertEquals(day.getFoods().size(), day.getFoods().size());
        day.getFoods().remove(0);
        assertEquals(day.getFoods().size(), day.getFoods().size());
    }

}