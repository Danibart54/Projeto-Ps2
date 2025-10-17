@Service
public class JobOfferService {

    @Autowired
    private JobOfferRepository jobOfferRepository;

    public JobOffer createJobOffer(JobOffer jobOffer) {
        return jobOfferRepository.save(jobOffer);
    }

    public List<JobOffer> getJobOffersByInterest(Set<String> areas) {
        return jobOfferRepository.findByAreaIn(areas);
    }

    public void closeJobOffer(Long id) {
        JobOffer jobOffer = jobOfferRepository.findById(id).orElseThrow(() -> new RuntimeException("Vaga não encontrada"));
        jobOffer.setClosed(true);
        jobOfferRepository.save(jobOffer);
    }
}
