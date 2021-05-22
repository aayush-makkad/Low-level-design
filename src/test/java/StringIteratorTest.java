import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


class StringIteratorTest {


    @Test
    public void testStringIterator() {
        StringIterator stringIterator = new StringIterator("L10e2t1C1o1d1e1");
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('L',stringIterator.next());
        assertEquals('e',stringIterator.next());
        assertEquals('e',stringIterator.next());
        assertEquals('t',stringIterator.next());
        assertEquals('C',stringIterator.next());
        assertEquals('o',stringIterator.next());
        assertTrue(stringIterator.hasNext());
        assertEquals('d',stringIterator.next());
        assertTrue(stringIterator.hasNext());
    }

}