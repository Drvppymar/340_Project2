import static org.junit.jupiter.api.Assertions.*;

public class BigNumArithmeticTest {

    /*Test to make sure that the reverse string method returns the string in reverse order.
     */
    @org.junit.jupiter.api.Test
    public void reverseString() {
        BigNumArithmetic b = new BigNumArithmetic();
        String s = "83947";
        assertEquals("74938", b.reverseString("83947"));
    }

    /*Test to make sure that stringToLList method returns a valid LList from the string passed in. Made a second LList to make sure that both of their first nodes
    equaled each other.
     */
    @org.junit.jupiter.api.Test
    public void stringToLList() {
        BigNumArithmetic b = new BigNumArithmetic();
        String s = "235";
        LList l = new LList();
        l.append("2");
        l.append("3");
        l.append("5");
        assertEquals(l.getValue(), b.stringToLList("235").getValue().toString());
    }

    /*Test to make sure that llistToString method returns the correct string. Appended items to a linked list and checked if
    the function returned what the string value should be.
     */
    @org.junit.jupiter.api.Test
    public void llistToString() {
        LList l = new LList();
        BigNumArithmetic b = new BigNumArithmetic();
        l.append("2");
        l.append("3");
        l.append("5");
        assertEquals("235", b.llistToString(l));
    }

    /*Test to make sure the mathAddition function works. Added two numbers together aas strings and made sure the sum was
    correct.
     */
    @org.junit.jupiter.api.Test
    public void mathAddition() {
        BigNumArithmetic b = new BigNumArithmetic();
        assertEquals("86886558560174", b.mathAddition("7570087", "86886550990087"));
        assertEquals("86886558560174", b.mathAddition("86886550990087", "7570087"));
    }

    /*Test to make sure that the stackRule method implements the use of the stack correctly and can take an array of operands and
    operators and perform the expression. Should pop off the solution of the expression off the stack.
     */
    @org.junit.jupiter.api.Test
    public void stackRule() {
        BigNumArithmetic b = new BigNumArithmetic();
        String[] line = new String[]{"1234", "0", "+"};
        assertEquals("1234", b.stackRule(line));
    }

     /*Test to make sure the mathMultiplication function works. Multiplied two numbers together as strings and made sure the product was
    correct.
     */
    @org.junit.jupiter.api.Test
    public void mathMultiplication() {
        BigNumArithmetic b = new BigNumArithmetic();
        assertEquals("4", b.mathMultiplication("2", "2"));
        assertEquals("0", b.mathMultiplication("0", "0"));
        assertEquals("8182278", b.mathMultiplication("8541", "958"));
        assertEquals("15326662543796", b.mathMultiplication("384634", "39847394"));
        assertEquals("8050996830848287500", b.mathMultiplication("948459475", "8488498500"));
    }

    /*Test to make sure the mathSubtraction function works. Subtract two numbers as strings and made sure the answer was
    correct.
     */
    @org.junit.jupiter.api.Test
    public void mathSubtraction() {
        BigNumArithmetic b = new BigNumArithmetic();
        assertEquals("8902892", b.mathSubtraction("9879867", "976975"));
        assertEquals("8902892", b.mathSubtraction("976975", "9879867"));
        assertEquals("0", b.mathSubtraction("35", "35"));
        assertEquals("342111292", b.mathSubtraction("987896970", "645785678"));
    }
}