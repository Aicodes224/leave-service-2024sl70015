package com.bits.hr; 

 

public class LeaveCalculator { 

 

    // Calculates remaining leaves: (total - taken) 

    public int calculateRemainingLeave(int totalLeave, int leavesTaken) { 

        if (totalLeave < 0 || leavesTaken < 0) { 

            throw new IllegalArgumentException("Count of leaves cannot be negative"); 

        } 

        if (leavesTaken > totalLeave) { 

            throw new IllegalArgumentException("Count of Leaves cannot exceed total leaves"); 

        } 

        return totalLeave - leavesTaken; 

    } 

 

    // Calculates cash payout: (balance * daily salary) 

    public double calculateEncashment(int leaveBalance, double dailySalaryRate) { 

        if (leaveBalance < 0 || dailySalaryRate < 0.0) { 

            throw new IllegalArgumentException("Balance and daily rate must be non-negative"); 

        } 

        return leaveBalance * dailySalaryRate; 

    } 

} 
