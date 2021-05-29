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
    }
}