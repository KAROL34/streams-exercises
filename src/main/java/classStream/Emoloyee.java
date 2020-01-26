package classStream;

import java.time.LocalDate;
import java.util.Date;

public abstract class Emoloyee {
    private Integer id;
    private String name;
    private String surname;
    private LocalDate birthdate;
    private LocalDate workStartedOn;

    @Override
    public String toString() {
        return "Emoloyee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                ", workStartedOn=" + workStartedOn +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public LocalDate getWorkStartedOn() {
        return workStartedOn;
    }

    public void setWorkStartedOn(LocalDate workStartedOn) {
        this.workStartedOn = workStartedOn;
    }

    public Emoloyee(Integer id, String name, String surname, LocalDate birthdate, LocalDate workStartedOn) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.birthdate = birthdate;
        this.workStartedOn = workStartedOn;
    }


    public Emoloyee() {

    }
}
