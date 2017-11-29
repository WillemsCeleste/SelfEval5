package be.cegeka.selfEval5.domain.incident;

import be.cegeka.selfEval5.domain.highway.Highway;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import java.math.BigDecimal;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class IncidentTest {

    private Incident incident;
    private Highway highway;

    @Before
    public void setUp() throws Exception {
        highway = new Highway("kapucijnenvoer", 2);
        incident = new Incident( "Moeder Colruyt Kapot", IncidentType.CAR_CRASH, BigDecimal.valueOf(0.05), highway);
    }

    @Test
    public void WhenCallingGetId_ShouldReturnCorrectId() throws Exception {
        assertThat(incident.getId()).isEqualTo(1);
    }

    @Test
    public void WhenCallingGetType_ShouldReturnCorrectType() throws Exception {
        assertThat(incident.getType()).isEqualTo(IncidentType.CAR_CRASH);
    }

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        assertThat(incident).isEqualTo(incident);
    }

    @Test
    public void equals_ObjectWithSameId_IsTrue() throws Exception {
        Incident expected = new Incident("Vader Colruyt Kapot", IncidentType.CAR_CRASH, BigDecimal.valueOf(0.05), highway);
        assertThat(incident).isEqualTo(expected);
    }

    @Test
    public void equals_nullObject_isFalse() throws Exception {
        assertThat(incident).isNotEqualTo(null);
    }

    @Test
    public void equals_otherClass_isFalse() throws Exception {
        assertThat(incident).isNotEqualTo(new Object());
    }

}