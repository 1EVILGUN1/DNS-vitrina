package dns.vitrina.server.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Date;

@Data
@Entity
@Inheritance(strategy = InheritanceType.JOINED)
@Table(name = "tasks")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private StatusTask status;

    @Column
    private Date created;

    @Column
    private Long vitrinaId;
}
