package dns.vitrina.server.repository;

import dns.vitrina.server.model.TaskSuccess;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskSuccessRepository extends JpaRepository<TaskSuccess, Long>  {
}
