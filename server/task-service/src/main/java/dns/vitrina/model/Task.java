package dns.vitrina.model;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private String description;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusTask status = StatusTask.PENDING;

    @Column(nullable = false)
    private LocalDate created = LocalDate.now();

    @Column
    private LocalDate endDate;

    @Column
    private LocalDate completedAt;

    // ID витрины, к которой относится задача
    @Column(name = "vitrina_id", nullable = false)
    private Long vitrinaId;

    // Список ID пользователей, связанных с задачей
    @ElementCollection
    @CollectionTable(name = "task_user_ids", joinColumns = @JoinColumn(name = "task_id"))
    @Column(name = "user_id")
    private List<Long> userIds = new ArrayList<>();
}
