package dns.vitrina.mapper;

import dns.vitrina.dto.task.TaskInTableResponseDto;
import dns.vitrina.facade.UserFacade;
import dns.vitrina.model.Task;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class TaskMapper {
    private final UserFacade userFacade;

    public TaskInTableResponseDto toTaskInTableResponseDto(Task task) {
        TaskInTableResponseDto dto = new TaskInTableResponseDto();
        dto.setId(task.getId());
        dto.setName(task.getName());
        dto.setDescription(task.getDescription());
        dto.setCreated(task.getCreated());
        dto.setEndDate(task.getEndDate());
        dto.setStatus(task.getStatus());
        dto.setUsers(userFacade.getListUsersByIds(task.getUserIds()));
        return dto;
    }
}
