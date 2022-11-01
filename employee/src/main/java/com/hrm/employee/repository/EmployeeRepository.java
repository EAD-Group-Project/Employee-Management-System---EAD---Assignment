package com.hrm.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrm.employee.model.Employee;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long>{
    @Query(value = "SELECT * FROM employees e WHERE CONCAT(e.first_name, e.last_name, e.email, e.department) LIKE %?1%", nativeQuery = true)
    public List<Employee> search(String keyword);
}
