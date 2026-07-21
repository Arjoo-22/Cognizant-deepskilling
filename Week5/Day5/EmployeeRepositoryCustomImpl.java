package com.cognizant.ormlearn.repository;

import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.cognizant.ormlearn.model.Employee;

@Repository
public class EmployeeRepositoryCustomImpl {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> searchEmployees(String name, Double salary) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Employee> cq = cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        Predicate predicate = cb.conjunction();

        // Dynamic filter by employee name
        if (name != null && !name.isEmpty()) {
            predicate = cb.and(predicate,
                    cb.like(employee.get("name"), "%" + name + "%"));
        }

        // Dynamic filter by salary
        if (salary != null) {
            predicate = cb.and(predicate,
                    cb.greaterThanOrEqualTo(employee.get("salary"), salary));
        }

        cq.select(employee).where(predicate);

        TypedQuery<Employee> query = entityManager.createQuery(cq);

        return query.getResultList();
    }
}