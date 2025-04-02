package dns.vitrina.service;


import dns.vitrina.dto.task.TaskInTableResponseDto;
import dns.vitrina.repository.TaskRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class TaskServiceImp implements TaskService {
    private final TaskRepository repository;


    @Override
    public TaskInTableResponseDto getById(Long id) {
        return null;
    }

    @Override
    public TaskInTableResponseDto getByVitrinaId(Long vitrinaId, Long id) {
        return null;
    }

    @Override
    public List<TaskInTableResponseDto> getAllByUserId(Long userId) {
        return List.of();
    }

    @Override
    public List<TaskInTableResponseDto> getAllByVitrinaId(Long vitrinaId) {
        return List.of();
    }
}
