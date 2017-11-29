package be.cegeka.selfEval5.application;

import be.cegeka.selfEval5.domain.user.User;
import be.cegeka.selfEval5.domain.user.UserService;
import org.assertj.core.api.Assertions;
import org.junit.Rule;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnit;
import org.mockito.junit.MockitoRule;

import static org.junit.Assert.*;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class UserControllerTest {

    @Rule
    public MockitoRule rule = MockitoJUnit.rule();

    @InjectMocks
    private UserController userController;

    @Mock
    private UserService userService;

    @Test
    public void whenCallingAddUser_ShouldCallOnUserService() throws Exception {
        userController.addUser("Seppe");

        verify(userService).addUser("Seppe");
    }

    @Test
    public void whenCallingGetUserDetails_ShouldCallOnUserService() throws Exception {
        User seppe = new User ("Seppe");

        when(userService.getUserDetails(seppe.getId())).thenReturn(seppe);
        Assertions.assertThat(userController.getUserDetails(seppe.getId())).isEqualTo(seppe);
    }

    @Test
    public void whenCallingGetAllUsers_ShouldCallOnUserService() throws Exception {
        userController.getAllUsers();
        verify(userService).getAllUsers();
    }
}