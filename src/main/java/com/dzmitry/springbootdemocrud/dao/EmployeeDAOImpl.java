package com.dzmitry.springbootdemocrud.dao;

import com.dzmitry.springbootdemocrud.entity.Employee;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;
import java.util.List;

@Repository
public class EmployeeDAOImpl implements EmployeeDAO {

    private EntityManager entityManager;

    @Autowired
    public EmployeeDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    @Override
    @Transactional
    public List<Employee> findAll() {

        Session session = entityManager.unwrap(Session.class);
        Query<Employee> query = session.createQuery("from Employee", Employee.class);
        List<Employee> employees = query.getResultList();
        return employees;
    }

    @Override
    @Transactional
    public Employee findById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Employee employee = session.get(Employee.class, id);
        return employee;
    }

    @Override
    @Transactional
    public void save(Employee employee) {
        Session session = entityManager.unwrap(Session.class);
        session.saveOrUpdate(employee);
    }

    @Override
    @Transactional
    public void deleteById(int id) {
        Session session = entityManager.unwrap(Session.class);
        Query query = session.createQuery("delete from Employee where id=:employeeId");
        query.setParameter("employeeId", id);
        query.executeUpdate();
    }
}
