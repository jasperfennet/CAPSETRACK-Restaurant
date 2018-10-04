package com.capgemini.restaurant.Repository;

import com.capgemini.restaurant.Models.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Integer> {


}
