package com.hrm.employee.repository;

import com.hrm.employee.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.hrm.employee.model.Employee;

import java.util.List;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long>{
    @Query(value = "SELECT * FROM departments d WHERE CONCAT(d.department_name) LIKE %?1%", nativeQuery = true)
    public List<Department> search(String keyword);

}


