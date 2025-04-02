package dns.vitrina.mapper;

import dns.vitrina.dto.task.TaskCompletedDto;
import dns.vitrina.dto.task.TaskCreatedDto;
import dns.vitrina.dto.task.TaskInTableResponseDto;
import dns.vitrina.model.Task;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.MappingTarget;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface TaskMapper {

    // Маппинг TaskCreatedDto -> Task для создания новой задачи
    @Mapping(target = "id", ignore = true) // ID генерируется базой данных
    @Mapping(target = "status", constant = "NEW") // Устанавливаем начальный статус NEW
    @Mapping(target = "created", expression = "java(java.time.LocalDate.now())") // Текущая дата
    @Mapping(target = "completedAt", ignore = true) // Изначально null
    @Mapping(target = "vitrinaId", source = "vitrinaId") // Передаем через параметр
    Task toTask(TaskCreatedDto dto, Long vitrinaId);

    // Маппинг TaskCompletedDto -> Task для обновления задачи при завершении
    @Mapping(target = "id", ignore = true) // ID не обновляется
    @Mapping(target = "created", ignore = true) // Дата создания не меняется
    @Mapping(target = "completedAt", expression = "java(java.time.LocalDate.now())") // Устанавливаем дату завершения
    void updateTaskFromDto(TaskCompletedDto dto, @MappingTarget Task task);

    // Маппинг Task -> TaskInTableResponseDto для отображения
    TaskInTableResponseDto toTaskInTableResponseDto(Task task);
}
