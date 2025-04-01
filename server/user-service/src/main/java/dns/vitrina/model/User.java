package dns.vitrina.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@NoArgsConstructor
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String firstName;

    @Column(nullable = false)
    private String lastName;

    @Column(nullable = false)
    private String password;

    // Список ID задач, связанных с пользователем (опционально)
    @ElementCollection
    @CollectionTable(name = "user_task_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "task_id")
    private List<Long> taskIds = new ArrayList<>();

    // Список ID витрин, связанных с пользователем (опционально)
    @ElementCollection
    @CollectionTable(name = "user_vitrina_ids", joinColumns = @JoinColumn(name = "user_id"))
    @Column(name = "vitrina_id")
    private List<Long> vitrinaIds = new ArrayList<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id != null && Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}