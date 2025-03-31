package dns.vitrina.server.dto;

import dns.vitrina.server.model.Task;
import lombok.Data;

import java.util.List;


@Data
public class UserDto {
    Long id;
    String firstName;
    String lastName;
    List<Task> tasks;
}