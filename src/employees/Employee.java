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
public abstract class Employee {
    public int id;
    public String firstName;
    public String lastName;
    public Date dateOfBirth;
    public String job;
    public double salary;

    public Employee(String firstName, String lastName, Date dateOfBirth, String job, double salary) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dateOfBirth = dateOfBirth;
        this.job = job;
        this.salary = salary;
    }
    
    public abstract double getSalary();
    
}
