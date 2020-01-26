import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class DateExercisesTest {
    DateExercises dateExercises=new DateExercises();


    @Test
    void shouldReturnAgeAdult() {

        assertEquals(35,dateExercises.getTheAge(LocalDate.of(1984,02,19)));
    }
    @Test
    void shouldReturnAgeChild() {

        assertEquals(0,dateExercises.getTheAge(LocalDate.of(2019,02,19)));
    }
}