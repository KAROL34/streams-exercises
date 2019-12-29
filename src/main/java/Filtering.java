import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Filtering {

    static final List<Integer> nums = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
    }};
    static final List<String> words = new ArrayList<String>() {{
        add("cat");
        add("dog");
        add("hamster");
    }};

    public static int theHighestNum(List list){
        return (int) list.stream().sorted(Comparator.reverseOrder()).findFirst().orElse(null);
    }
    public  static int sumOfAll(List list){
        return (int) list.stream().collect(Collectors.summingInt(Integer::intValue));
    }
    public static int theSecondHighestNum(List list){
        return (int) list.stream().sorted(Comparator.reverseOrder()).limit(2).sorted(Comparator.naturalOrder()).findFirst().orElse(null);
    }



}
