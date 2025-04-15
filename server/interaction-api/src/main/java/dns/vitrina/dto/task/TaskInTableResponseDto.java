package dns.vitrina.dto.task;

import dns.vitrina.dto.user.UserDto;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

//Dto для задачи которая будет отображаться в таблице задач витрины
@Data
public class TaskInTableResponseDto {
    private Long id;
    private String name;
    private String description;
    private StatusTask status;
    private LocalDate created;
    private LocalDate endDate;
    private List<UserDto> users;
}
