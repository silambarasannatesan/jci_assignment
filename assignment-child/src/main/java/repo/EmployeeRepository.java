package repo;

import com.jci.assignment.model.Company;
import com.jci.assignment.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

public interface  EmployeeRepository extends CrudRepository<Employee, Integer>{

}
