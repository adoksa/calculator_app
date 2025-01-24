import org.example.Calculator;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTestTest {
Calculator calculator;

    @Test
    void add() {
        assertEquals(7,calculator.add(4,3));
        assertNotEquals(7, calculator.add(3,3));
    }
    @Test
    void sub() {
        assertEquals(2, calculator.sub(4, 2));
        assertNotEquals(2, calculator.sub(5, 2));
    }
    @Test
    void multi() {
        assertEquals(10, calculator.multi(2, 5));
        assertNotEquals(2, calculator.multi(5, 2));
    }
    @Test
    void divide() {
        assertEquals(2, calculator.divide(4, 2));
        assertNotEquals(5, calculator.divide(15, 2));
    }
    @Test
    void divideByZero(){
        assertThrows(IllegalArgumentException.class,()-> calculator.divide(10, 0));
    }
}