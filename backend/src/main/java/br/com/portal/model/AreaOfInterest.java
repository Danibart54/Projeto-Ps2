
import javax.persistence.*;

@Entity
public class AreaOfInterest {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    // Getters e Setters
}
