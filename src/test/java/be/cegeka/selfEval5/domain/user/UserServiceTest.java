package be.cegeka.selfEval5.domain.user;

import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;

public class UserServiceTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserService userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void whenCallingAddUser_ShouldCallUserRepository() throws Exception {
        userService.addUser("Liefje");
        verify(userRepository).addUser(new User("Liefje"));
    }

    @Test
    public void whenCallingGetUserDetails_ShouldCallUserRepository() throws Exception {
        userService.getUserDetails(2);
        verify(userService).getUserDetails(2);
    }

    @Test
    public void whenCallingGetAllUsers_ShouldCallUserRepository() throws Exception {
        userService.getAllUsers();
        verify(userRepository).getAllUsers();
    }
}