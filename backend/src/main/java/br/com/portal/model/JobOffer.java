@Entity
public class JobOffer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Company company;

    private String title;
    private String description;
    private String area;
    private String location;
    private String modality;
    private int hours;
    private String requirements;

    @ManyToMany
    private Set<Student> applicants = new HashSet<>();

    private boolean closed;

    // Getters e Setters
}
