package be.cegeka.selfEval5.domain.incident;

import be.cegeka.selfEval5.domain.highway.Highway;
import be.cegeka.selfEval5.domain.highway.HighwayRepository;

import javax.inject.Inject;
import javax.inject.Named;
import java.math.BigDecimal;

@Named
public class IncidentService {

    @Inject
    private IncidentRepository incidentRepository;

    @Inject
    private HighwayRepository highwayRepository;

    public void addIncident(String name, IncidentType type, BigDecimal distance, int highwayId) {
        Highway highway = highwayRepository.getHighwayDetails(highwayId);

        incidentRepository.addIncident(new Incident(name, type, distance, highway));
    }
}
