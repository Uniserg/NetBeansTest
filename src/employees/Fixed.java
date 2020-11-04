/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.util.Date;

/**
 *
 * @author Serg
 */
public class Fixed extends Employee {

    public Fixed(String firstName, String lastName, Date dateOfBirth, String job, double salary) {
        super(firstName, lastName, dateOfBirth, job, salary);
    }
    
    @Override
    public double getSalary() {
        return salary;
    }
    
    
}
