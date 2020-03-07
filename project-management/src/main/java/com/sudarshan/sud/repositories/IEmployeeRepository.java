package com.sudarshan.sud.repositories;

import org.springframework.data.repository.CrudRepository;

import com.sudarshan.sud.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long>{

}
