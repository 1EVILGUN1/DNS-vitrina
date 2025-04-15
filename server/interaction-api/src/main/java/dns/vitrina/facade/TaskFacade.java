package dns.vitrina.facade;

import dns.vitrina.dto.task.TaskInTableResponseDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "task-service",path = "/task-service")
public interface TaskFacade {

    @GetMapping("/{taskId}")
    TaskInTableResponseDto getTaskDtoById(@PathVariable("taskId") Long taskId);

    @GetMapping("/{taskId}/on-vitrina/{vitrinaId}")
    TaskInTableResponseDto getTaskDtoByVitrinaId(@PathVariable("vitrinaId") Long vitrinaId,
                                                 @PathVariable("taskId") Long taskId);

    @GetMapping("/tasks/{userId}")
    List<TaskInTableResponseDto> getTasksByUserId(@PathVariable("userId") Long userId);

    @GetMapping("/tasks-on-vitrina/{vitrinaId}")
    List<TaskInTableResponseDto> getTasksByVitrina(@PathVariable("vitrinaId") Long vitrinaId);

    @GetMapping("/user-tasks")
    List<TaskInTableResponseDto> getListTasksByIds(@RequestParam("taskIds") List<Long> taskIds);
}
