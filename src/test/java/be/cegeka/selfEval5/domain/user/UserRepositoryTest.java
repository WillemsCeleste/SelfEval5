package be.cegeka.selfEval5.domain.user;

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
public class UserRepositoryTest {

    @Inject
    private UserRepository userRepository;

    @PersistenceContext
    private EntityManager entityManager;

    private User liefje, nelson;

    @Before
    public void setUp() throws Exception {
        liefje = new User("liefje");
        entityManager.persist(liefje);

        nelson = new User("nelson");
        entityManager.persist(nelson);
    }

    @Test
    public void getAllUsers_ShouldReturnAllUsers() throws Exception {
        Assertions.assertThat(userRepository.getAllUsers()).contains(liefje, nelson);
    }

    @Test
    public void getUserDetails_ShouldReturnUserDetails() throws Exception {
        User user = userRepository.getUserDetails(nelson.getId());
        Assertions.assertThat(user).isEqualTo(nelson);
    }

    @Test
    public void addUser_ShouldAddUserToUsersTable() throws Exception {
        User weirdo = new User("weirdo");
        userRepository.addUser(weirdo);
        Assertions.assertThat(userRepository.getAllUsers()).contains(weirdo);
    }
}