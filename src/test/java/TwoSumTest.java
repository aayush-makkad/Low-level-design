import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TwoSumTest {

    private TwoSum twoSum;

    @BeforeEach
    public void setup() {
        twoSum = new TwoSum();
    }

    @Test
    public void testTwoSum() {
        twoSum.add(3);   // [] --> [1]
        twoSum.add(2);   // [1,3] --> [1,3,5]
        twoSum.add(1);   // [1] --> [1,3]
        assertTrue(twoSum.find(4));
        assertFalse(twoSum.find(2));
    }

}