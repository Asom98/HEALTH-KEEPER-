package modelS;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;


class WorkoutTest {
    /**
     * Testing:
     *
     * <ul>
     *   <li>{@link Workout#Workout(String, int, Date)}
     *   <li>{@link Workout#setDate(Date)}
     *   <li>{@link Workout#setDuration(int)}
     *   <li>{@link Workout#setWorkOutTyp(String)}
     * </ul>
     */
    @Test
    void testWorkout() {
        LocalDateTime atStartOfDayResult = LocalDate.of(1970, 1, 1).atStartOfDay();
        Workout actualWorkout = new Workout("Work Out Typ", 1,
                Date.from(atStartOfDayResult.atZone(ZoneId.of("UTC")).toInstant()));

        LocalDateTime atStartOfDayResult1 = LocalDate.of(1970, 1, 1).atStartOfDay();
        Date fromResult = Date.from(atStartOfDayResult1.atZone(ZoneId.of("UTC")).toInstant());

        actualWorkout.setDate(fromResult);
        actualWorkout.setDuration(1);
        actualWorkout.setWorkOutTyp("Work Out Typ");

        Assertions.assertSame(fromResult, actualWorkout.getDate());
        Assertions.assertEquals(1, actualWorkout.getDuration());
        Assertions.assertEquals("Work Out Typ", actualWorkout.getWorkOutTyp());
    }
}

