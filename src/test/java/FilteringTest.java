import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

class FilteringTest {
    static final List<Integer> nums = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
    }};
    static final Map<Integer, String> wordsmap = new HashMap<Integer, String>() {{
        put(1, "cat");
        put(2, "dog");
        put(3, "hamster");
    }};
    static final List<String> words = new ArrayList<String>() {{
        add("cat");
        add("dog");
        add("hamster");
    }};
@Test
void shouldReturnMapMadeOftwoList(){
    assertThat(wordsmap,is(Filtering.combineWithTwoList()));
}

    @Test
    @DisplayName("Number 3 after reverse sorting is the highest one")
    void shouldReturnTheHighestValue() {
        assertEquals(3,Filtering.theHighestNum(nums));
    }

    @Test

        void shouldReturnSumOfAllIntegers(){
            assertEquals(6,Filtering.sumOfAll(nums));

    }

    @Test
    void shouldReturnTheSecondHighest() {
       assertEquals(2,Filtering.theSecondHighestNum(nums));
    }

    @Test
    void shouldReturnCountAllLettersfromMap() {assertEquals(13,Filtering.countAllLetters());
    }

    @Test
    void countLetterInEveryStringinMap() {
        assertEquals(Long.valueOf(2),Filtering.countLetterInEveryStringinMap('a'));
    }

    @Test
    void countCharAttachedInList() {
        List<Character> characterList=new ArrayList<>(Arrays.asList('a','c'));
        Map<Character,Integer>mapexpet=new HashMap<>();
        mapexpet.put('a',2);
        mapexpet.put('c',1);
        assertThat(mapexpet,is(Filtering.countCharAttachedInList(characterList)));


    }

    @Test
    void createMapWithIntGeneratorAndList() {
        Map<Character,Integer>mapexpet=new HashMap<>();

    assertThat(wordsmap,is(Filtering.createMapWithIntGeneratorAndList()));
    }
}