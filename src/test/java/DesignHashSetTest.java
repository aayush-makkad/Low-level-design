import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;


class DesignHashSetTest {

    private DesignHashSet.MyHashSet myHashSet;

    @BeforeEach
    public void setup() {
        myHashSet = new DesignHashSet.MyHashSet();
    }

    @Test
    public void testHashSet() {
        myHashSet.add(1);
        myHashSet.add(2);
        assertTrue(myHashSet.contains(1));
        assertFalse(myHashSet.contains(3));
        myHashSet.add(2);
        assertTrue(myHashSet.contains(2));
        myHashSet.remove(2);   // set = [1]
        assertFalse(myHashSet.contains(2));
    }


}