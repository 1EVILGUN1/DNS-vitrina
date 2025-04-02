package dns.vitrina.dto.task;

import lombok.Data;

import java.time.LocalDate;


@Data
public class TaskInTableResponseDto {
    private Long id;
    private String name;
    private String description;
    private StatusTask status;
    private LocalDate created;
    private LocalDate endDate;
}
