package dns.vitrina.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@Entity
@Table(name = "vitrins")
public class Vitrina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    private String name;

    @Column
    private int x;

    @Column
    private int y;

    @Column
    private int width;

    @Column
    private int height;

    @OneToMany
    List<User> usersToVitrina = new ArrayList<>();

    public void addUserToVitrina(User user) {
        usersToVitrina.add(user);
    }
}
