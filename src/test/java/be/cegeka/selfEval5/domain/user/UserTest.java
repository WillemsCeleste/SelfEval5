package be.cegeka.selfEval5.domain.user;

import org.assertj.core.api.Assertions;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class UserTest {

    private User user;

    @Before
    public void setUp() throws Exception {
        user = new User(1, "Kiki");

    }

    @Test
    public void WhenCallingGetNameOnAGivenUser_ShouldReturnCorrectName() throws Exception {
        Assertions.assertThat(user.getName()).isEqualTo("Kiki");
    }

    @Test
    public void equals_sameObject_isTrue() throws Exception {
        Assertions.assertThat(user).isEqualTo(user);
    }
}