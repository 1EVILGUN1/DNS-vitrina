package dns.vitrina.controller;

import dns.vitrina.dto.task.TaskInTableResponseDto;
import dns.vitrina.facade.TaskFacade;
import dns.vitrina.service.TaskService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
public class TaskControllerFacade implements TaskFacade {
    private final TaskService service;


    @Override
    public TaskInTableResponseDto getTaskDtoById(Long taskId) {
        return service.getById(taskId);
    }

    @Override
    public TaskInTableResponseDto getTaskDtoByVitrinaId(Long vitrinaId, Long taskId) {
        return service.getByVitrinaId(vitrinaId,taskId);
    }

    @Override
    public List<TaskInTableResponseDto> getTasksByUserId(Long userId) {
        return service.getAllByUserId(userId);
    }

    @Override
    public List<TaskInTableResponseDto> getTasksByVitrina(Long vitrinaId) {
        return service.getAllByVitrinaId(vitrinaId);
    }
}
