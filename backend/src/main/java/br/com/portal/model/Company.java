@Entity
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @OneToOne
    private User user;
    
    private String cnpj;
    private String phone;
    private String address;

    @ManyToMany
    private Set<AreaOfInterest> areasOfActuation = new HashSet<>();

    // Getters e Setters
}
