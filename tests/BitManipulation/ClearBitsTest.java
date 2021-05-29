package BitManipulation;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class ClearBitsTest {
    @BeforeEach
    void setUp(){
    }

    @Test
    void clearIthBit () {
        Assertions.assertEquals(254 ,ClearBits.clearIthBit(255,1));
        Assertions.assertEquals(127 ,ClearBits.clearIthBit(255,8));
        Assertions.assertEquals(1 , ClearBits.clearIthBit(65,7));
        Assertions.assertThrows(IllegalArgumentException.class , ()-> ClearBits.clearIthBit(1 , 33));
        Assertions.assertThrows(IllegalArgumentException.class , ()-> ClearBits.clearIthBit(1 , 0));
    }
}