package dns.vitrina.repository;

import dns.vitrina.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    boolean existsByLastName(String lastName);
    boolean findByLastName(String lastName);

    // Новый метод для поиска по vitrinaId
    @Query("SELECT u FROM User u JOIN u.vitrinaIds v WHERE v = :vitrinaId")
    List<User> findUsersByVitrinaId(@Param("vitrinaId") Long vitrinaId);

    List<User> findByIdIn(List<Long> ids);
}