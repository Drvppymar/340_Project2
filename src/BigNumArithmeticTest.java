import static org.junit.jupiter.api.Assertions.*;

class BigNumArithmeticTest {

    @org.junit.jupiter.api.Test
    void lineToArray() {
        BigNumArithmetic b = new BigNumArithmetic();
        b.lineToArray("");
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
        BigNumArithmetic b = new BigNumArithmetic();
        LList l = new LList();
        l.append("2");
        l.append("5");
        l.append("7");
        assertEquals("257", b.llistToString(l));
    }

    @org.junit.jupiter.api.Test
    void mathAddition() {
    }
}