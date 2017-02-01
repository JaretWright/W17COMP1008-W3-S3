
package w17jan25;

import java.time.LocalDate;

/**
 *
 * @author JWright
 */
public class BasePlusCommissionEmployee extends CommissionEmployee
{
    private double monthlyBaseSalary;
    
    public BasePlusCommissionEmployee(String first, String last, int sin, 
                                LocalDate dob, double comRate, double monthlySalary) 
    {
        super(first, last, sin, dob, comRate);
        setMonthlySalary(monthlySalary);
    }
    
    /**
     * This validates that the monthly salary is greater than 0 and sets the
     * instance variable
     */
    public void setMonthlySalary(double newSalary)
    {
        if (newSalary > 0)
            monthlyBaseSalary = newSalary;
        else
            throw new IllegalArgumentException("Salary values must be greater than 0");
    }
    
    public double getBaseSalary()
    {
        return this.monthlyBaseSalary;
    }
    
    @Override
    public PayCheque getPayCheck()
    {
        double payAmount = monthlyBaseSalary + super.getCommissions();
        PayCheque newPay = new PayCheque(super.toString(),"base + commission", payAmount);
        return newPay;
    }
}
