package com.dzmitry.springbootdemocrud.dao_jpa_repository;

import com.dzmitry.springbootdemocrud.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
