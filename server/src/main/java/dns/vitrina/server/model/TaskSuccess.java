package dns.vitrina.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "tasks_success")
public class TaskSuccess {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long vitrinaId; // ID задачи из vitrins
    private Long userId; // ID пользователя, выполнившего задачу
    private String name;
    private String description;
    private LocalDate completedAt;
}
