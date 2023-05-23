package org.java.calculator.abs;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assumptions.assumeTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	private Calculator c;
	
	@BeforeEach
	public void init() {
		c = new Calculator() {
		};
	}
	
	@Test
    public void getAddTest() {
		float num1 = 2;
		float num2 = 3;
        float expectedValue = 5;
        float actualValue = c.add(num1 , num2);
        assertEquals(expectedValue, actualValue , "Addizione");
    }

    @Test
    public void getSubstactTest() {
    	float num1 = 15;
    	float num2 = 5;
        float expectedValue = 10;
        float actualValue = c.substract(num1 , num2);
        assertEquals(expectedValue, actualValue, "Sottrazione");
    }

    @Test
    public void getDivideTest() {
    	float num1 = 20;
    	float num2 = 2;
    	
    	assumeTrue(num2!=0);
    	
        float expectedValue = 10;
        float actualValue = c.divide(num1, num2);
        assertEquals(expectedValue, actualValue, "Divisione");
    }
    
    @Test
	public void getDivExcTest() {
    	float num1 = 20;
    	float num2 = 2;
    	
		assumeTrue(num2 == 0);
		
		assertThrows(Exception.class,
				() -> c.divide(num1, num2),
				"Deve sollevare eccezione");
	}

    @Test
    public void getMultiplyTest() {
    	float num1 = 50;
    	float num2 = 2;
    	
        float expectedValue = 100;
        float actualValue = c.multiply(50, 2);
        assertEquals(expectedValue, actualValue, "Moltiplicazione");
    }

}
