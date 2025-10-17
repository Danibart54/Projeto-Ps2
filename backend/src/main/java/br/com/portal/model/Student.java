
import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private User user;
    
    private String cpf;
    private String course;

    @ManyToMany
    private Set<AreaOfInterest> areasOfInterest = new HashSet<>();

    // Getters e Setters
}
