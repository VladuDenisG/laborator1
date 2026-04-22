package ro.ulbs.proiectaresoftware.lab6.advanced;

import lab5.advanced.NewIntCalculator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NewIntCalculatorTest {
    private NewIntCalculator calc;

    @BeforeEach
    void setup() {
        calc = new NewIntCalculator();
        calc.init();
    }

    @Test
    void testAddPositive() {
        calc.add(10).add(5);
        assertEquals(15, (Integer)calc.result());
    }

    @Test
    void testAddNegatives() {
        calc.add(-5).add(-5);
        assertEquals(-10, (Integer)calc.result());
    }

    @Test
    void testSubtractPositives() {
        calc.add(20);
        calc.subtract(5);
        assertEquals(15, (Integer)calc.result());
    }

    @Test
    void testSubtractNegatives() {
        calc.add(-10);
        calc.subtract(-5);
        assertEquals(-5, (Integer)calc.result());
    }

    @Test
    void testMultiplyPositives() {
        calc.add(5);
        calc.multiply(2);
        assertEquals(10, (Integer)calc.result());
    }

    @Test
    void testMultiplyNegatives() {
        calc.add(5);
        calc.multiply(-2);
        assertEquals(-10, (Integer)calc.result());
    }

    @Test
    void testMultiplyBy0() {
        calc.add(5);
        calc.multiply(0);
        assertEquals(0, (Integer)calc.result());
    }

    @Test
    void testDividePositives() {
        calc.add(10);
        calc.divide(2);
        assertEquals(5, (Integer)calc.result());
    }

    @Test
    void testDivideNegatives() {
        calc.add(-10);
        calc.divide(2);
        assertEquals(-5, (Integer)calc.result());
    }

    @Test
    void testDivideBy0() {
        calc.add(10);
        assertThrows(ArithmeticException.class, () -> calc.divide(0));
    }
}