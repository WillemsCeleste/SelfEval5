package be.cegeka.selfEval5.application;

import be.cegeka.selfEval5.domain.highway.Highway;
import be.cegeka.selfEval5.domain.incident.Incident;
import be.cegeka.selfEval5.domain.incident.IncidentService;
import be.cegeka.selfEval5.domain.incident.IncidentType;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.math.BigDecimal;

@RestController
@RequestMapping(path = "/incident")
@Transactional
public class IncidentController {

    @Inject
    private IncidentService incidentService;

    @PostMapping
    public void addIncident(@RequestParam(value = "name", required = false) String name,
                            @RequestParam(value = "type", required = true) IncidentType type,
                            @RequestParam(value = "distance", required = true) BigDecimal distance,
                            @RequestParam(value = "highway", required = true) int highwayId) {
        incidentService.addIncident(name, type, distance, highwayId);
    }
}
