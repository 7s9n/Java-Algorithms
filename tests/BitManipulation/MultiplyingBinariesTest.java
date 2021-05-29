package BitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MultiplyingBinariesTest {

    @Test
    void multiply () {
        assertEquals(80,MultiplyingBinaries.multiply(8,10));
        assertEquals(0,MultiplyingBinaries.multiply(0,10));
        assertEquals(0,MultiplyingBinaries.multiply(8,0));
        assertEquals(-160,MultiplyingBinaries.multiply(-2,80));
    }
}