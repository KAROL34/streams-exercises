package classStream;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Stream;

public class Repository {
    public Stream<Worker> getWorkers() {
        return Stream.of(
                new Worker(3,"Darek","Glanowski", LocalDate.of(1984, 2,19), LocalDate.of(2019,12,12),1),
        new Worker(4,"Marek","Męcik", LocalDate.of(1980,03,19), LocalDate.of(2017,02,12),1),
        new Worker(5,"Karol","Bat", LocalDate.of(1984, 3,19), LocalDate.of(2018, 6,12),2),
        new Worker(6,"Paweł","Kot", LocalDate.of(1985,02,19), null,2)
        );
    }
    public Stream<Manger> getManagers() {
        return Stream.of( new Manger(1,"Jan","Kowalski",LocalDate.of(1982,01,01),LocalDate.of(2019,12,11), Arrays.asList(3,4)),
        new Manger(2,"Jan","Kowalski",LocalDate.of(1982,01,01),LocalDate.of(2019,12,11),Arrays.asList(5,6))
        );
    }
    public Stream<Task> getTasks(){
        return Stream.of(new Task(1,"posprzątaj kuchnie", LocalDateTime.of(LocalDate.of(2020,01,15), LocalTime.of(10,10,10)),3),
                new Task(2,"skoduj go", LocalDateTime.of(LocalDate.of(2020, 1,16), LocalTime.of(10,10,10)),4),
                new Task(3,"zatancz", LocalDateTime.of(LocalDate.of(2020,01,19), LocalTime.of(10,10,10)),5),
                new Task(5,"wypij", LocalDateTime.of(LocalDate.of(2020,01,19), LocalTime.of(10,10,10)),5),
                new Task(4,"posprzątaj łazienkę", LocalDateTime.of(LocalDate.of(2020,01,15), LocalTime.of(10,10,10)),6));

    }


    }






