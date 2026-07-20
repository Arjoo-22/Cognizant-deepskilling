

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.ormlearn.model.Employee;

public interface EmployeeRepositoryAverageSalary
        extends JpaRepository<Employee, Integer> {

    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department.id=:id")
    double getAverageSalary(@Param("id") int id);

}