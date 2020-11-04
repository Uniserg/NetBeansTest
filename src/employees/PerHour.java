package employees;

import java.util.Date;

/**
 *
 * @author Serg
 */
public class PerHour extends Employee{

    public PerHour(String firstName, String lastName, Date dateOfBirth, String job, double salary) {
        super(firstName, lastName, dateOfBirth, job, salary);
    }
    
    @Override
    public double getSalary() {
        return 20.8 * 8 * salary;
    }
    
}
