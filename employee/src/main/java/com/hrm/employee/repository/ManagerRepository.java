package com.hrm.employee.repository;

import com.hrm.employee.model.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;


import java.util.List;

@Repository
public interface ManagerRepository extends JpaRepository<Manager, Long>{
    @Query(value = "SELECT * FROM managers m WHERE CONCAT(m.first_name, m.last_name, m.email, m.department) LIKE %?1%", nativeQuery = true)
    public List<Manager> search(String keyword);

    @Query(value = "select * from managers where email = ?1 and password = ?2", nativeQuery = true)
    public Manager validateManager(String email,String password);
}
