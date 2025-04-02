package dns.vitrina.service;

import dns.vitrina.dto.task.TaskInTableResponseDto;

import java.util.List;

public interface TaskService {

    TaskInTableResponseDto getById (Long id);

    TaskInTableResponseDto getByVitrinaId (Long vitrinaId, Long id);

    List<TaskInTableResponseDto> getAllByUserId (Long userId);

    List<TaskInTableResponseDto> getAllByVitrinaId (Long vitrinaId);
}
