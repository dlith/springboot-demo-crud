package com.dzmitry.springbootdemocrud.dao;

import com.dzmitry.springbootdemocrud.entity.Employee;

import java.util.List;

public interface EmployeeDAO {

    public List<Employee> findAll();
}
