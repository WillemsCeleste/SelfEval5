package be.cegeka.selfEval5.domain.highway;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class HighwayService {

    @Inject
    private HighwayRepository highwayRepository;

    public void addHighway(String name, int length) {
        highwayRepository.addHighway(new Highway(name, length));
    }

    public Highway getHighwayDetails(int id) {
        return highwayRepository.getHighwayDetails(id);
    }

    public List<Highway> getAllHighways() {
        return highwayRepository.getAllHighways();
    }
}
