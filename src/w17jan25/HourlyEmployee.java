
package w17jan25;

import java.time.LocalDate;

/**
 *
 * @author jwright
 */
public class HourlyEmployee extends Employee {
    private double hoursWorked, hourlyRate;
    private final double MINIMUMWAGE = 11.40;
    
    public HourlyEmployee(String first, String last, int sin, LocalDate dob, double hourlyRate) {
        super(first, last, sin, dob);
        hoursWorked = 0;
        setHourlyRate(hourlyRate);
    }
    
    
    /**
     * This method will ensure that the employee is being paid at least minimum wage and set the
     * hourly rate
     * @return 
     */
    public void setHourlyRate(double newPayRate)
    {
        if (newPayRate >= MINIMUMWAGE)
            hourlyRate = newPayRate;
        else
            throw new IllegalArgumentException("The hourly rate must be greater than or equal to " +
                                                MINIMUMWAGE);
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * This method will receive a double that represents the hours worked.  It will
     * validate it to be in the range 1-16 and add it to the hours worked.
     * @return 
     */
    
    
    
    @Override
    public PayCheque getPayCheck() 
    {
        double payAmount = hourlyRate * hoursWorked;
        
        PayCheque newPay = new PayCheque(super.toString(), "Hourly pay", payAmount);
        
        hoursWorked = 0; //reset the hours for the next pay period
        
        return newPay;
    }
    
    
}
