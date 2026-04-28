package ro.ulbs.proiectaresoftware.lab6.advanced;

import lab5.advanced.DoubleCalculator;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

class DoubleCalculatorTest {
    private DoubleCalculator calc;

    @BeforeEach
    void setup() {
        calc = new DoubleCalculator();
        calc.init();
    }

    @Test
    void testAddPositive() {
        calc.add(10.5).add(4.5);
        assertEquals(15.0, (Double)calc.result(), 0.001);
    }

    @Test
    void testAddNegatives() {
        calc.add(-5.5).add(-2.5);
        assertEquals(-8.0, (Double)calc.result(), 0.001);
    }

    @Test
    void testSubtractPositives() {
        calc.add(20.0).subtract(5.0);
        assertEquals(15.0, (Double)calc.result(), 0.001);
    }

    @Test
    void testSubtractNegatives() {
        calc.add(-10).subtract(-5);
        assertEquals(-5, (Double)calc.result());
    }

    @Test
    void testMultiplyPositives() {
        calc.add(5.0).multiply(2.0);
        assertEquals(10.0, (Double)calc.result(), 0.001);
    }

    @Test
    void testMultiplyNegatives() {
        calc.add(5).multiply(-2);
        assertEquals(-10, (Double)calc.result());
    }

    @Test
    void testMultiplyBy0() {
        calc.add(5).multiply(0);
        assertEquals(0, (Double)calc.result());
    }

    @Test
    void testDividePositives() {
        calc.add(10.0).divide(2.0);
        assertEquals(5.0, (Double)calc.result(), 0.001);
    }

    @Test
    void testDivideNegatives() {
        calc.add(-10).divide(2);
        assertEquals(-5, (Double)calc.result());
    }

    @Test
    void testDivideByZero() {
        calc.add(10.0);
        assertThrows(ArithmeticException.class, () -> {
            calc.divide(0.0);
        });
    }
}