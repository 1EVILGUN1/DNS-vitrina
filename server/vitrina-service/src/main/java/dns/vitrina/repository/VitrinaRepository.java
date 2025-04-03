package dns.vitrina.repository;

import dns.vitrina.model.Vitrina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VitrinaRepository extends JpaRepository<Vitrina, Long> {

    List<Vitrina> findByIdIn(List<Long> vitrinaIds);
}