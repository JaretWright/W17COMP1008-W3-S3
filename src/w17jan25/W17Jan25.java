
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
       Employee emp1 = new Employee("Adam","Baum",1234,LocalDate.of(1977, Month.MARCH, 10));
       
       System.out.printf("The first employee is %s%n", emp1.toString());
    }
    
}
