package repo;

import com.jci.assignment.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface  CompanyRepository extends CrudRepository<Company, Integer>{

}
