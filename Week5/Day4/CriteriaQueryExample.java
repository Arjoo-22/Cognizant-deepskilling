
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.CriteriaBuilder;
import jakarta.persistence.criteria.CriteriaQuery;
import jakarta.persistence.criteria.Predicate;
import jakarta.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.example.ormlearn.model.Employee;

@Repository
public class CriteriaQueryExample {

    @PersistenceContext
    private EntityManager entityManager;

    public List<Employee> searchEmployees(
            String name,
            Double salary) {

        CriteriaBuilder cb = entityManager.getCriteriaBuilder();

        CriteriaQuery<Employee> cq =
                cb.createQuery(Employee.class);

        Root<Employee> employee = cq.from(Employee.class);

        List<Predicate> predicates =
                new ArrayList<>();

        if(name != null) {
            predicates.add(
                    cb.like(employee.get("name"),
                            "%" + name + "%"));
        }

        if(salary != null) {
            predicates.add(
                    cb.greaterThan(employee.get("salary"),
                            salary));
        }

        cq.where(predicates.toArray(new Predicate[0]));

        TypedQuery<Employee> query =
                entityManager.createQuery(cq);

        return query.getResultList();
    }
}