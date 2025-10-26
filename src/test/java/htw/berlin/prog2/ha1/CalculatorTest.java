package htw.berlin.prog2.ha1;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Retro calculator")
class CalculatorTest {

    @Test
    @DisplayName("should display result after adding two positive multi-digit numbers")
    void testPositiveAddition() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "40";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display result after getting the square root of two")
    void testSquareRoot() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(2);
        calc.pressUnaryOperationKey("√");

        String expected = "1.41421356";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when dividing by zero")
    void testDivisionByZero() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressBinaryOperationKey("/");
        calc.pressDigitKey(0);
        calc.pressEqualsKey();

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should display error when drawing the square root of a negative number")
    void testSquareRootOfNegative() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(7);
        calc.pressNegativeKey();
        calc.pressUnaryOperationKey("√");

        String expected = "Error";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }

    @Test
    @DisplayName("should not allow multiple decimal dots")
    void testMultipleDecimalDots() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(1);
        calc.pressDotKey();
        calc.pressDigitKey(7);
        calc.pressDotKey();
        calc.pressDigitKey(8);

        String expected = "1.78";
        String actual = calc.readScreen();

        assertEquals(expected, actual);
    }


    //TODO hier weitere Tests erstellen

    @Test
    @DisplayName("should display result after  subtraction of two positive single-digit numbers")
    void testPositiveSubtraktion(){
        Calculator calc = new Calculator();

        calc.pressDigitKey(6);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "3";
        String actual = calc.readScreen();

        assertEquals(expected,actual);
    }
    @Test
    void  testNegativeTaste() {
        Calculator calc = new Calculator();

        calc.pressDigitKey(0);
        calc.pressNegativeKey();

        String exp = "0";
        String actual = calc.readScreen();

        assertEquals(exp,actual);
    }

    @Test
    @DisplayName("should display the latest value and operation after pressing clear key 1 time ")
    void testClearKeyOnce() {

        Calculator calc  = new Calculator();

        calc.pressDigitKey(8);
        calc.pressBinaryOperationKey("+");
        calc.pressDigitKey(2);
        calc.pressEqualsKey();


        calc.pressClearKey();

        int expectedLatestValue = 10;
        String expectedLatesOp = "+";

        assertEquals(expectedLatestValue,calc.getLatestValue());
        assertEquals(expectedLatesOp,calc.getLatestOperation());

    }
    @Test
    @DisplayName("should display the latest value as 0 and latest operation as empty after pressing clear key 2 times ")
    void testClearKeyTwice() {

        Calculator calc  = new Calculator();

        calc.pressDigitKey(9);
        calc.pressBinaryOperationKey("-");
        calc.pressDigitKey(3);
        calc.pressEqualsKey();

        String expected = "6";
        String actual = calc.readScreen();
        assertEquals(expected,actual);

        calc.pressClearKey();
        calc.pressClearKey();
        expected = "0";
        double expLatVal = 0.0;
        String expLatOp = "";

        assertEquals(expLatVal,calc.getLatestValue());
        assertEquals(expLatOp,calc.getLatestOperation());
    }

