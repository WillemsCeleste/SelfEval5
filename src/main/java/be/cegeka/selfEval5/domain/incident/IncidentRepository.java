package be.cegeka.selfEval5.domain.incident;

import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Named
public class IncidentRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addIncident(Incident incident) {
        entityManager.persist(incident);
    }
}
