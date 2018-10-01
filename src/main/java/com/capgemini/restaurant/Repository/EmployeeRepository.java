package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.*;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import java.util.*;

@Repository
public class EmployeeRepository {

    private Map<Integer, Employee> employees = new HashMap<>();

    @PostConstruct
    public void generateEmployee() {
        Employee empl =new Employee("a","b","ADMIN");
        empl.setRole("ADMIN");
        empl.setUserName("a");
        empl.setPassword("$2a$04$yuGmsUZgKyfQBHfHmWO2aOBAg9U3oiDJdIIEdkZp2rKiquTc7xKme");
        System.out.println(empl.getRole()+","+ empl.getUserName()+","+ empl.getPassword());

        save(empl);
    }

    public void save(Employee newEmployee) {
        this.employees.put(newEmployee.getId(), newEmployee);
    }

    public Collection<Employee> findAll() {
        return this.employees.values();
    }

    public Employee findByEmployeeNR(int employeeNR) {
        return this.employees.get(employeeNR);
    }

    public Employee findByEmployeeName(String employeeName){
        for(Employee empl : employees.values()){
            if(empl.getLastName().equals(employeeName)){
                return empl;
            }
        }
        System.out.println("not found");
        Employee empl =new Employee("a","b","ADMIN");
        empl.setRole("ADMIN");
        empl.setUserName("a");
        empl.setPassword("$2a$04$yuGmsUZgKyfQBHfHmWO2aOBAg9U3oiDJdIIEdkZp2rKiquTc7xKme");
        return empl;
    }

    public void deleteByEmployeeNR(int employeeNr) {
        this.employees.remove(employeeNr);
    }

    public Employee updateEmployee(int employeeNR, Employee update) {
        Employee employee = this.findByEmployeeNR(employeeNR);
        deleteByEmployeeNR(employeeNR);
        save(update);

        return update;
    }

}
