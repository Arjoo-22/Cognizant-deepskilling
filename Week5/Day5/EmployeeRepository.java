package com.cognizant.ormlearn.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {

    // Get all permanent employees with Department and Skill details
    @Query("SELECT DISTINCT e FROM Employee e "
         + "LEFT JOIN FETCH e.department "
         + "LEFT JOIN FETCH e.skillList "
         + "WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();
}