import static org.junit.jupiter.api.Assertions.*;

class BigNumArithmeticTest {

    @org.junit.jupiter.api.Test
    void lineToArray() {

    }

    @org.junit.jupiter.api.Test
    void arrayToString() {
    }

    @org.junit.jupiter.api.Test
    void reverseString() {
    }

    @org.junit.jupiter.api.Test
    void stringToLList() {
    }

    @org.junit.jupiter.api.Test
    void llistToString() {
    }

    @org.junit.jupiter.api.Test
    void mathAddition() {
        BigNumArithmetic b = new BigNumArithmetic();
        assertEquals("1234", b.mathAddition("1234", "0"));
    }

    @org.junit.jupiter.api.Test
    void stackRule() {
        BigNumArithmetic b = new BigNumArithmetic();
        String[] line = new String[]{"1234", "0", "+"};
        assertEquals("1234", b.stackRule(line));
    }
}