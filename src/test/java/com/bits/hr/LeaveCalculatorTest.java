 package com.bits.hr; 

 

import org.junit.Before; 

import org.junit.Test; 

import static org.junit.Assert.*; 

 

public class LeaveCalculatorTest { 

 

    private LeaveCalculator calculator; 

 

    @Before 

    public void setUp() { 

        calculator = new LeaveCalculator(); 

    } 

 

    // Test 1:Balance calculation 

    @Test 

    public void testCalculateRemainingLeaveValid() { 

        int remaining = calculator.calculateRemainingLeave(20, 10); 

        assertEquals("Remaining balance should be 10", 10, remaining); 

    } 

 

    // Test 2: Standard encashment calculation 

    @Test 

    public void testCalculateEncashment() { 

        double encashment = calculator.calculateEncashment(10, 2500.0); 

        assertEquals("Encashment value should be 25000.0", 25000.0, encashment, 0.001); 

    } 

 

    // Test 3: Exception test when leaves taken more than total 

    @Test(expected = IllegalArgumentException.class) 

    public void testLeavesTakenExceedsTotalThrowsException() { 

        calculator.calculateRemainingLeave(11, 20); 

    } 

} 
