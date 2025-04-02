package dns.vitrina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "vitrinas")
public class Vitrina {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int x;

    @Column
    private int y;

    @Column
    private int width;

    @Column
    private int height;

    // Список ID пользователей, связанных с витриной
    @ElementCollection
    @CollectionTable(name = "vitrina_user_ids", joinColumns = @JoinColumn(name = "vitrina_id"))
    @Column(name = "user_id")
    private List<Long> userIds = new ArrayList<>();

    // Список ID задач, связанных с витриной
    @ElementCollection
    @CollectionTable(name = "vitrina_task_ids", joinColumns = @JoinColumn(name = "vitrina_id"))
    @Column(name = "task_id")
    private List<Long> taskIds = new ArrayList<>();
}
