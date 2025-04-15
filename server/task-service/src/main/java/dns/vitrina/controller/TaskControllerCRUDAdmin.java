package dns.vitrina.controller;

import dns.vitrina.dto.task.TaskCreatedDto;
import dns.vitrina.dto.task.TaskInTableResponseDto;
import dns.vitrina.model.Task;
import dns.vitrina.service.TaskServiceCRUD;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Validated
@Slf4j
@RequiredArgsConstructor
@RequestMapping("admin/task")
public class TaskControllerCRUDAdmin {
    private final TaskServiceCRUD service;

    @CrossOrigin
    @PostMapping
    public void create(@RequestBody @Valid TaskCreatedDto dto){
        service.create(dto);
    }

    @CrossOrigin
    @PutMapping
    public void update(@RequestBody Task task){
        service.update(task);
    }

    @CrossOrigin
    @DeleteMapping
    public void delete(@RequestBody Task task){
        service.delete(task);
    }
}
