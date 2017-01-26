package w17jan25;

import java.time.LocalDate;

/**
 *
 * @author jwright
 */
public class PayCheque {
    private String employeeName, notes;
    private double amount;
    private LocalDate dateIssued;
    private int chequeNumber;
    
    private static int nextChequeNumber = 1000;

    public PayCheque(String employeeName, String notes, double payAmount) {
        this.employeeName = employeeName;
        this.notes = notes;
        setPayAmount(payAmount);
        
        chequeNumber = nextChequeNumber;
        nextChequeNumber++;
    }
    
    /**
     * This method will validate that the pay amount is > 0
     */
    private void setPayAmount(double payAmount)
    {
        if (payAmount > 0)
            amount = payAmount;
        else
            throw new IllegalArgumentException("Pay amounts must be greater than 0");
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public String getNotes() {
        return notes;
    }

    public double getAmount() {
        return amount;
    }

    public LocalDate getDateIssued() {
        return dateIssued;
    }

    public int getChequeNumber() {
        return chequeNumber;
    }
    
    public String toString()
    {
        return String.format("Cheque #:%d made out to %s for the amount of $%.2f",
                                                            chequeNumber,
                                                            employeeName,
                                                            amount);
    }
    
    
    
    
}
