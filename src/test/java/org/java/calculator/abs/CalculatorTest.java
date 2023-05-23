package org.java.calculator.abs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import java.util.Random;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;

public class CalculatorTest {
	private Calculator c;
	private static final int NUM_TESTS = 10;
	private static final int RND_BOUND = 100;
	private static float num1;
	private static float num2;
	
	@BeforeEach
	public void init() {
		Random rnd = new Random();
		
		c = new Calculator() {
		};
		
		num1 = rnd.nextFloat(RND_BOUND);
		num2 = rnd.nextFloat(RND_BOUND);
	}
	
	@RepeatedTest(NUM_TESTS)
    public void getAddTest() {
        float expectedValue = num1+num2;
        float actualValue = c.add(num1 , num2);
        assertEquals(expectedValue, actualValue , "Addizione");
    }

	@RepeatedTest(NUM_TESTS)
    public void getSubstactTest() {
        float expectedValue = num1-num2;
        float actualValue = c.substract(num1 , num2);
        assertEquals(expectedValue, actualValue, "Sottrazione");
    }

	@RepeatedTest(NUM_TESTS)
    public void getDivideTest() {
    	assumeTrue(num2!=0);
    	
        float expectedValue = num1/num2;
        float actualValue = c.divide(num1, num2);
        assertEquals(expectedValue, actualValue, "Divisione");
    }
    
	@RepeatedTest(NUM_TESTS)
	public void getDivExcTest() {
		assumeTrue(num2 == 0);
		
		assertThrows(Exception.class,
				() -> c.divide(num1, num2),
				"Deve sollevare eccezione");
	}

	@RepeatedTest(NUM_TESTS)
    public void getMultiplyTest() {
        float expectedValue = num1*num2;
        float actualValue = c.multiply(num1, num2);
        assertEquals(expectedValue, actualValue, "Moltiplicazione");
    }

}
