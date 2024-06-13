package com.example.srinivas_22bce9653;

import junit.framework.TestCase;

public class CalculatorTest extends TestCase {

    private Calculator calculator;

    protected void setUp() throws Exception {
        super.setUp();
        calculator = new Calculator();
    }

    public void testAdd() {
        int expected = 30;
        int actual = calculator.add(10, 20);
        assertEquals(expected, actual);
    }

    public void testMultiply() {
        int exc = 20;
        int act = calculator.multiply(5, 4);
        assertEquals(exc, act);
    }

    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
