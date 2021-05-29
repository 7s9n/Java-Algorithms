package BitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SetBitsTest {

    @Test
    void setIthBit () {
        Assertions.assertEquals(255 ,SetBits.setIthBit(254,1));
        Assertions.assertEquals(255 ,SetBits.setIthBit(127,8));
        Assertions.assertEquals(65 , SetBits.setIthBit(1,7));
        Assertions.assertThrows(IllegalArgumentException.class , ()-> SetBits.setIthBit(1 , 33));
        Assertions.assertThrows(IllegalArgumentException.class , ()-> SetBits.setIthBit(1 , 0));
        Assertions.assertEquals(1 , SetBits.setIthBitTo0(65,7));
    }
}