package com.ecvictor.calculator;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {
    Calculator calculator;
    @BeforeClass
    public static void setupBeforeClass(){
        System.out.println("Before Class");
    }

    @Before
    public void setup(){
        calculator = new Calculator();
    }

    @Test
    public void add() throws Exception {

        assertTrue("Add funtion not equal",6==calculator.add(2,3));
    }

    @Test
    public void divide() throws Exception {
        calculator.divide(1,1);
    }

    @Test
    public void multiple() throws Exception {
        assertEquals(5,calculator.multiple(2,3));
    }

}