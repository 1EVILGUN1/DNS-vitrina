package dns.vitrina.service;

import dns.vitrina.server.model.Task;
import dns.vitrina.server.model.TaskSuccess;
import dns.vitrina.server.repository.TaskRepository;
import dns.vitrina.server.repository.TaskSuccessRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TaskService {
    private final TaskRepository repository;
    private final TaskSuccessRepository taskSuccessRepository;

    @Transactional
    public void save(Task task) {
        repository.save(task);
    }

    @Transactional
    public void delete (Task task) {
        repository.delete(task);
    }

    @Transactional
    public void saveSuccess (TaskSuccess taskSuccess) {
        taskSuccessRepository.save(taskSuccess);
    }
}
