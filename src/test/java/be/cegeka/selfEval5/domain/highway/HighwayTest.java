package be.cegeka.selfEval5.domain.highway;

import be.cegeka.selfEval5.domain.user.User;
import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.*;

public class HighwayTest {

    private Highway highway;

    @Before
    public void setUp() throws Exception {
        highway = new Highway("R666", 66);
    }

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        Assertions.assertThat(highway).isEqualTo(highway);
    }

    @Test
    public void equals_ObjectWithSameEverthing_IsTrue() throws Exception {
        Highway expected = new Highway("R666", 66);
        assertThat(highway).isEqualTo(expected);
    }

    @Test
    public void equals_nullObject_isFalse() throws Exception {
        assertThat(highway).isNotEqualTo(null);
    }

    @Test
    public void equals_otherClass_isFalse() throws Exception {
        assertThat(highway).isNotEqualTo(new Object());
    }
}