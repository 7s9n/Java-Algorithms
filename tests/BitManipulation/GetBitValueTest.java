package BitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GetBitValueTest {

    @Test
    void getIthBit () {
        assertEquals(0 , GetBitValue.getIthBit(65,8));
        assertEquals(1 , GetBitValue.getIthBit(65,7));
        assertEquals(1 , GetBitValue.getIthBit(65,1));
        assertThrows(IllegalArgumentException.class , () -> GetBitValue.getIthBit(1,99));
    }
}