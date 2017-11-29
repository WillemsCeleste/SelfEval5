package be.cegeka.selfEval5.application;

import be.cegeka.selfEval5.domain.user.User;
import be.cegeka.selfEval5.domain.user.UserService;
import org.springframework.web.bind.annotation.*;

import javax.inject.Inject;
import javax.transaction.Transactional;
import java.util.List;

@RestController
@RequestMapping(path = "/user")
@Transactional
public class UserController {

    @Inject
    private UserService userService;

    @PostMapping
    public void addUser(@RequestParam(value = "name", required = true) String name) {
        userService.addUser(name);
    }

    @GetMapping
    public User getUserDetails(@RequestParam(value = "id", required = true) int id) {
        return userService.getUserDetails(id);
    }

    @GetMapping(path = "/all")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }
}
