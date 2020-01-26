package classStream;

import java.time.LocalDate;
import java.util.List;

public class Manger extends Emoloyee{

    public Manger(Integer id, String name, String surname, LocalDate birthdate, LocalDate workStartedOn, List<Integer> idWorkersList) {
        super(id, name, surname, birthdate, workStartedOn);
        this.idWorkersList = idWorkersList;
    }
    List<Integer> idWorkersList;

    @Override
    public String toString() {
        return "Manager{" +
                "id=" + getId() +" "+
                "name=" + getName() +" "+
                "surname=" + getSurname() +" "+
                "listWOrer=" + idWorkersList +
                "birthdate=" + getBirthdate() +" "+
                "whenEmployed=" + getWorkStartedOn() +" "+
                '}';
    }

    public List<Integer> getIdWorkersList() {
        return idWorkersList;
    }

    public void setIdWorkersList(List<Integer> idWorkersList) {
        this.idWorkersList = idWorkersList;
    }
}
