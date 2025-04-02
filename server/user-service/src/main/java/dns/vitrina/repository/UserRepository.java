package dns.vitrina.repository;

import dns.vitrina.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLastName(String lastName);
    boolean findByLastName(String lastName);
}