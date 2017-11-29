package be.cegeka.selfEval5.domain.highway;


import javax.inject.Named;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Named
public class HighwayRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public void addHighway(Highway highway) {
        entityManager.persist(highway);
    }

    public Highway getHighwayDetails(int id) {
        return entityManager.find(Highway.class, id);
    }

    public List<Highway> getAllHighways() {
        return entityManager.createQuery("select h from Highway h", Highway.class).getResultList();
    }
}
