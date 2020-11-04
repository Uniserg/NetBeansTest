/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employees;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.stream.Collectors;

/**
 *
 * @author Serg
 */
public class Employees {
    int curId = 0;
    ArrayList<Employee> employees;
    int number;

    public Employees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
    
    public Employees() {
        this.employees = new ArrayList<>();
    }
    
    public void add(Employee employee){
        employee.id = ++curId;
        employees.add(employee);
    }
    
    public void remove(Employee employee){
        employees.remove(employee);
    }
    
    private int order(Employee e1, Employee e2) {
        int compasion = Double.compare(e2.getSalary(), e1.getSalary());
        if (compasion == 0){
            return e1.lastName.compareTo(e2.lastName);
        }
        return compasion;
    }
    
    public ArrayList<Employee> orderBySalary(){
        return employees.stream().sorted(this::order).collect(Collectors.toCollection(ArrayList::new));
    }

    @Override
    public String toString() {
        StringBuilder l = new StringBuilder();
        l.append(String.format("%60s", "ТАБЛИЦА СОТРУДНИКОВ"))
                .append('\n')
                .append(String.format("%20s %20s %20s %20s %20s", "ID", "Фамилия", "Имя", "Должность", "Зарплата\n"));
        employees.forEach(e -> {
            l.append(String.format("%20d %20s %20s %20s %20s %20.2f\n", e.id, e.lastName, e.firstName, new SimpleDateFormat("dd.MM.Y").format(e.dateOfBirth) , e.job, e.getSalary()));
        });
        return l.toString();
    }
}
