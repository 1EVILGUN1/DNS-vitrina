package dns.vitrina.repository;

import dns.vitrina.server.model.Vitrina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VitrinaRepository extends JpaRepository<Vitrina, Long> {
}