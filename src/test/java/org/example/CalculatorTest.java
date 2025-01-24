package org.example;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void add() {
        Calculator calc = new Calculator();
        calc.add(1, 2);
    }

    @Test
    void sub() {
        Calculator calc = new Calculator();
        calc.sub(1, 2);
    }

    @Test
    void multi() {
        Calculator calc = new Calculator();
        calc.multi(1, 2);
    }

    @Test
    void divide() {
        Calculator calc = new Calculator();
        calc.divide(1, 2);
    }
}