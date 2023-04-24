package repo;

import com.jci.assignment.model.Building;
import com.jci.assignment.model.Company;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface BuildingRepository extends CrudRepository<Building, Integer>{

}
