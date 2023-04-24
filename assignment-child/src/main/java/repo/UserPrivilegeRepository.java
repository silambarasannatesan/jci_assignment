package repo;

import com.jci.assignment.model.rbac.UserAccount;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPrivilegeRepository extends JpaRepository<UserAccount, Integer> {
    UserAccount findByUsername(String username);
}
