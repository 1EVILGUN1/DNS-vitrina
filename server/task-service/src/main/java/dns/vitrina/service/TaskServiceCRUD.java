package dns.vitrina.service;


import dns.vitrina.dto.task.TaskCreatedDto;
import dns.vitrina.model.Task;

public interface TaskServiceCRUD {

    void create(TaskCreatedDto dto);

    void update(Task task);

    void delete(Task task);
}
