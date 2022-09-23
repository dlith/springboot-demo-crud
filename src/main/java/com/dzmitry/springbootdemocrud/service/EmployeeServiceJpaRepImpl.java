package com.dzmitry.springbootdemocrud.service;

import com.dzmitry.springbootdemocrud.dao_jpa_repository.EmployeeRepository;
import com.dzmitry.springbootdemocrud.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceJpaRepImpl implements EmployeeService{

    public EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeServiceJpaRepImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(int id) {
        return employeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        employeeRepository.save(employee);
    }

    @Override
    public void deleteById(int id) {
        employeeRepository.deleteById(id);
    }
}
