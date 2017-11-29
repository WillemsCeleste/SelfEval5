package be.cegeka.selfEval5.domain.highway;

import be.cegeka.selfEval5.Application;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@ContextConfiguration(classes = Application.class)
@Transactional
public class HighwayRepositoryTest {

    @Inject
    private HighwayRepository highwayRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private Highway dering, geldenaakse;

    @Before
    public void setUp() throws Exception {
        dering = new Highway("R0", 17);
        entityManager.persist(dering);

        geldenaakse = new Highway("geldenaakse", 5);
        entityManager.persist(geldenaakse);
    }


    @Test
    public void getAllHighways_ShouldReturnAllHighways() throws Exception {
        Assertions.assertThat(highwayRepository.getAllHighways()).contains(dering, geldenaakse);
    }

    @Test
    public void getDetails_ShouldReturnHighwayDetails() throws Exception {
        Highway highway = highwayRepository.getHighwayDetails(dering.getId());
        Assertions.assertThat(highway).isEqualTo(dering);
    }

    @Test
    public void addHighway_ShouldAddHighwayToHighwaysTable() throws Exception {
        Highway someroad = new Highway("someroad", 88);
        highwayRepository.addHighway(someroad);
        Assertions.assertThat(highwayRepository.getAllHighways()).contains(someroad);
    }
}