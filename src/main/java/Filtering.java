import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static java.util.stream.Collectors.*;

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
    static final Map<Integer, String> wordsmap = new HashMap<Integer, String>() {{
        put(1, "cat");
        put(2, "dog");
        put(3, "hamster");
    }};


    public static Map<Integer,String>createMapWithIntGeneratorAndList(){
        return IntStream.range(0,words.size()).collect(HashMap::new,(m,i)->m.put((i+1),words.get(i)),Map::putAll);
    }
    public static Map<Integer,String> combineWithTwoList(){
        return IntStream.range(0, nums.size())
                .collect(
                        HashMap::new,
                        (m, i) -> m.put(nums.get(i), words.get(i)),
                        Map::putAll
                );

    }
    public static Map<Integer,Boolean> mapNumberandDivededBy(int n){
        return IntStream.rangeClosed(1,10).collect(HashMap::new,(m,i)->m.put(i,i%n==0),Map::putAll);
    }
    public static Map<Integer,Boolean> mapNumberandDivededBy(){
        return IntStream.rangeClosed(1,10).collect(HashMap::new,(m,i)->m.put(i,i%2==0),Map::putAll);
    }
    public static String string01IfIsDiveded(int i){
        return IntStream.rangeClosed(1,10).map(e->{if(e%i==0){return 1;
        }else
            return 0;
        }).mapToObj(Integer::toString).collect(Collectors.joining());
    }
    public static List<String> concatKeyAndValueFromMap(Map<Integer, String> wordsmap) {
        return Filtering.wordsmap.entrySet()
                .stream()
                .map(entry -> entry.getKey() + entry.getValue())
                .collect(Collectors.toList());
    }

    public static int theHighestNum(List list) {
        return (int) list.stream()
                .sorted(Comparator.reverseOrder())
                .findFirst()
                .orElse(null);
    }

    public static int sumOfAll(List list) {
        return (int) list.stream()
                .collect(Collectors.summingInt(Integer::intValue));
    }

    public static int theSecondHighestNum(List list) {
        return (int) list.stream()
                .sorted(Comparator.reverseOrder())
                .limit(2)
                .sorted(Comparator.naturalOrder())
                .findFirst()
                .orElse(null);
    }

    /*
    Given a list of Strings, write a method that returns a list of all strings that start with the letter 'a' (lower case) and have exactly 3 letters.
     TIP: Use Java 8 Lambdas and Streams API's.
     */
    public List<String> search(List<String> list) {
        return list.stream()
                .filter(x -> x.startsWith("a"))
                .filter(x -> x.length() == 3)
                .collect(Collectors.toList());
    }

    /*
    Write a method that returns a comma separated string based on a given list of integers.
     Each element should be preceded by the letter 'e' if the number is even, and preceded by the letter 'o' if the number is odd.
      For example, if the input list is (3,44), the output should be 'o3,e44'.
     */
    public String getString(List<Integer> list) {
        return list.stream()
                .map(i -> i % 2 == 0 ? "e" + i : "o" + i)
                .collect(joining(","));
    }

    public static boolean isPrime(long n) {
        return LongStream.rangeClosed(2, (long) Math.sqrt(n))
                .allMatch(i -> n % i != 0);
    }

    public List<Long> listOfPrimeNumbers(Integer max) {


        return IntStream.rangeClosed(0, max)
                .asLongStream()
                .filter(Filtering::isPrime)
                .boxed()
                .collect(Collectors.toList());
    }

    public void doSthNtines(long n) {
    }

    public static void main(String[] args) {
        Filtering filtering = new Filtering();
        List<Long> listOfPrimeContains7Number = filtering.listOfPrimeNumbers(100)
                .stream()
                .map(s -> String.valueOf(s))
                .filter(e -> e.contains("7"))
                .map(x -> Long.valueOf(x))
                .collect(Collectors.toList());
        System.out.println(listOfPrimeContains7Number);
        System.out.println(concatKeyAndValueFromMap(wordsmap));
        System.out.println("*********");
        System.out.println(Filtering.countEachCharinWholeStringsinMap());
        System.out.println("*********");
        List<Character> characterList=new ArrayList<>(Arrays.asList('a','c'));
        System.out.println(Filtering.countCharAttachedInList(characterList));
        System.out.println("*****mapNumberandDivededBy2");
        System.out.println(Filtering.mapNumberandDivededBy(3));System.out.println("*****string01IfIsDiveded");
        System.out.println(Filtering.string01IfIsDiveded(2));
        String xxx=Filtering.string01IfIsDiveded(1);
        System.out.println(Filtering.mapNumberandDivededBy(3));System.out.println("*****binary");
        System.out.println(Filtering.binaryToText(xxx));
        System.out.println();
    }


    public static String binaryToText(String binary) {
        return Arrays.stream(binary.split("(?<=\\G.{8})"))/* regex to split the bits array by 8*/
                .parallel()
                .map(eightBits -> (char)Integer.parseInt(eightBits, 2))
                .collect(
                        StringBuilder::new,
                        StringBuilder::append,
                        StringBuilder::append
                ).toString();
    }



    public static int countAllLetters() {
        return wordsmap.entrySet().stream().mapToInt(x -> x.getValue().length()).sum();
    }

    public static Long countLetterInEveryStringinMap(Character c) {

        return wordsmap.entrySet().stream()
                .map(x -> x.getValue())
                .collect(Collectors.joining())
                .chars().filter(x -> x == c)
                .count();
    }

    /*
Map<String, Long> result = Stream.of(str.split(""))
	                             .collect(groupingBy(s -> s,
                                          mapping(s -> s, counting())));
     */
    public static Map<Character, Integer> countEachCharinWholeStringsinMap() {
        return wordsmap.entrySet()
                .stream()
                .map(x -> x.getValue())
                .collect(Collectors.joining())
                .chars()
                .mapToObj(x -> (char) x)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));
        //      .entrySet()
        //     .stream()
        //   .collect(Collectors.toMap(Map.Entry::getKey,Map.Entry::getValue,(e1,e2)->e1));


    }

    public static Map<Character, Integer> countCharAttachedInList(List<Character> listaChar) {
        return wordsmap.entrySet()
                .stream()
                .map(x -> x.getValue())
                .collect(Collectors.joining())
                .chars()
                .mapToObj(x -> (char) x)
                .map(Character::toLowerCase)
                .filter(x->listaChar.contains(Character.toLowerCase(x)))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.summingInt(c -> 1)));


    }
}
