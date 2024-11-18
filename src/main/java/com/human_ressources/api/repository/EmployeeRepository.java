package com.human_ressources.api.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.human_ressources.api.model.Employee;
@Repository
public interface EmployeeRepository extends CrudRepository<Employee, Long>{
}
