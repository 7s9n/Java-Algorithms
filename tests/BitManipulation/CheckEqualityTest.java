package BitManipulation;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CheckEqualityTest {

    @Test
    void checkEquality () {
        assertTrue(CheckEquality.checkEquality(-1,-1));
        assertTrue(CheckEquality.checkEquality(1024,1024));
        assertFalse(CheckEquality.checkEquality(-88,-1));
    }
}