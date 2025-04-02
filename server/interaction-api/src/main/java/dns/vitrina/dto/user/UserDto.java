package dns.vitrina.dto.user;

import dns.vitrina.dto.task.TaskInTableResponseDto;
import lombok.Data;

import java.util.List;


@Data
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    List<TaskInTableResponseDto> tasks;
}