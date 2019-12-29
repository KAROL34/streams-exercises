import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;

class FilteringTest {
    static final List<Integer> nums = new ArrayList<Integer>() {{
        add(1);
        add(2);
        add(3);
    }};


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
}