package classStream;

import java.time.LocalDate;
import java.util.Date;

public class Worker extends Emoloyee {
    Integer mangerId;


    @Override
    public String toString() {
        return "Worker{" +
                "id=" + getId() +" "+
                "name=" + getName() +" "+
                "surname=" + getSurname() +" "+
                "birthdate=" + getBirthdate() +" "+
                "whenEmployed=" + getWorkStartedOn() +" "+
                "mangerId=" + mangerId +
                '}';
    }

    public void setMangerId(Integer mangerId) {
        this.mangerId = mangerId;
    }

    public Worker(Integer id, String name, String surname, LocalDate birthdate, LocalDate whenWorkStart, Integer mangerId){
        super(id, name, surname, birthdate, whenWorkStart);
        this.mangerId=mangerId;
    }

    public Integer getMangerId() {
        return mangerId;
    }


}
