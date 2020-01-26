package classStream;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

class Service {

    private final Repository repository=new Repository();


    public Optional<Worker> findEmployeeByid(Integer integer){
        return  repository.getWorkers().filter(x->x.getId().equals(integer)).findFirst();
    }
    public List<Worker> getAllWorker(){
    return repository.getWorkers().collect(Collectors.toList());
    }
    public  List<Worker> getsortedWorkers(){
        return repository.getWorkers()
                .filter(x->x.getWorkStartedOn()!=null)
                .sorted(Comparator.comparing(Emoloyee::getWorkStartedOn))
                .collect(Collectors.toList());

    }
    public Integer getTheAgeOfTheOldestWorker(){
       return repository.getWorkers().map(Emoloyee::getBirthdate).filter(Objects::nonNull).mapToInt(x -> (Period.between(x, LocalDate.now())).getYears()).boxed().max(Comparator.naturalOrder()).orElse(0);
    }
    public Map<Manger,List<Worker>> getMapofManagerAndWorkers(){
        return repository.getManagers()
                .collect(HashMap::new,(m,i)->m.put(i,repository.getWorkers()
                        .filter(x-> x.mangerId.equals(i.getId()))
                        .collect(Collectors.toList())),Map::putAll);
    }
    public Map<Worker,Long> getSumOfEachTaskOnWorker(){
        return repository.getWorkers()
                .collect(HashMap::new,(m,i)->m.put(i,repository.getTasks()
                        .filter(x->x.getAssignetToEmployeeId()
                                .equals(i.getId()))
                        .count()),Map::putAll);

    }    public Map<String,Long> getNameandCountTaskOnEachWorker(){
        return repository.getWorkers()
                .collect(HashMap::new,(m,i)->m.put(i.getName(),repository.getTasks()
                        .filter(x->x.getAssignetToEmployeeId()
                                .equals(i.getId()))
                        .count()),Map::putAll);

    }
    public  Map<String, Long> workersPerName(
            ) {
        return repository.getWorkers()
                .collect(Collectors.groupingBy(Worker::getName,
                        Collectors.counting()));
    }
    public Integer getTotalDaysFromEmployment(){
        return repository.getWorkers()
                .map(Emoloyee::getWorkStartedOn)
                .filter(Objects::nonNull)
                .mapToInt(x-> (int) ChronoUnit.DAYS.between(x,LocalDate.now()))
                .sum();
    }


    public static void main(String[] args) {
         Service service=new Service();
        System.out.println(service.getsortedWorkers());
        System.out.println(service.getTheAgeOfTheOldestWorker());
        System.out.println(service.getMapofManagerAndWorkers());
        System.out.println(service.getSumOfEachTaskOnWorker());
        System.out.println(service.getNameandCountTaskOnEachWorker());
        System.out.println(service.workersPerName());
        System.out.println(service.getTotalDaysFromEmployment());


    }


}
