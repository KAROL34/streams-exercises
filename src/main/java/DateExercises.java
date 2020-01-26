import java.time.LocalDate;
import java.time.Period;

public class DateExercises {

    public Integer getTheAge(LocalDate localDate){
        if (localDate==null)
        {return 0;}
        return Period.between(localDate,LocalDate.now()).getYears();
    }
}
