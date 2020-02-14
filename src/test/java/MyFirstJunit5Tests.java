
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MyFirstJunit5Tests {

    @Test
    void testNumbers1() {
        assertEquals(2, 2);
    }

    @Test
    void testNumbers2() {
        assertEquals(2, 1);
    }
}
