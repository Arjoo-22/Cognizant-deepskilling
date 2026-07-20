

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.ormlearn.model.Employee;

public interface EmployeeRepositoryNative
        extends JpaRepository<Employee, Integer> {

    @Query(value="SELECT * FROM employee",
           nativeQuery = true)
    List<Employee> getAllEmployeesNative();

}