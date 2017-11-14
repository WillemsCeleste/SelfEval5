package be.cegeka.selfEval5.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User(1, "Kiki");

    }

    @Test
    public void WhenCallingGetNameOnAGivenUser_ShouldReturnCorrectName() throws Exception {
        assertThat(user.getName()).isEqualTo("Kiki");
    }

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        assertThat(user).isEqualTo(user);
    }

    @Test
    public void equals_ObjectWithSameEverthing_IsTrue() throws Exception {
        User expected = new User(1, "Kiki");
        assertThat(user).isEqualTo(expected);
    }

    @Test
    public void equals_nullObject_isFalse() throws Exception {
        assertThat(user).isNotEqualTo(null);
    }

    @Test
    public void equals_otherClass_isFalse() throws Exception {
        assertThat(user).isNotEqualTo(new Object());
    }
}