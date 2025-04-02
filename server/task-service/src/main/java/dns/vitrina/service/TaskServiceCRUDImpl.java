package dns.vitrina.service;

import dns.vitrina.dto.task.TaskCreatedDto;
import dns.vitrina.model.Task;
import dns.vitrina.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceCRUDImpl implements TaskServiceCRUD {
    private final TaskRepository taskRepository;
    private final TaskService service;

    @Override
    @Transactional
    public void create(TaskCreatedDto dto) {

    }

    @Override
    @Transactional
    public void update(Task task) {
    }

    @Override
    @Transactional
    public void delete(Task task) {

    }
}
