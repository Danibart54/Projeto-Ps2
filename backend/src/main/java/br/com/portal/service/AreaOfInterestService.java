

import br.com.portal.model.AreaOfInterest;
import br.com.portal.repository.AreaOfInterestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

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
