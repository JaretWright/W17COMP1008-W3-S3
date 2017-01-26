
package w17jan25;

import java.time.LocalDate;
import java.time.Month;

/**
 *
 * @author jwright
 */
public class W17Jan25 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
       HourlyEmployee emp1 = new HourlyEmployee("Adam","Baum",1234,
                                                LocalDate.of(1977, Month.MARCH, 10), 25.20);
       
       System.out.printf("The first employee is %s%n", emp1.toString());
       
       emp1.recordHoursWorked(8);
       emp1.recordHoursWorked(3);
       emp1.recordHoursWorked(8);
       
       System.out.printf("%s%n",  emp1.getPayCheck());
    }
    
}
