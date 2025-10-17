
@Service
public class AreaOfInterestService {

    @Autowired
    private AreaOfInterestRepository areaOfInterestRepository;

    public AreaOfInterest createAreaOfInterest(AreaOfInterest area) {
        return areaOfInterestRepository.save(area);
    }

    public List<AreaOfInterest> getAllAreas() {
        return areaOfInterestRepository.findAll();
    }
}
