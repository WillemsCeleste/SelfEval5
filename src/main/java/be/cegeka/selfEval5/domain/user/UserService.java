package be.cegeka.selfEval5.domain.user;

import javax.inject.Inject;
import javax.inject.Named;
import java.util.List;

@Named
public class UserService {

    @Inject
    private UserRepository userRepository;

    public void addUser(String name) {
        userRepository.addUser(new User(name));
    }

    public User getUserDetails(int id) {
        return userRepository.getUserDetails(id);
    }

    public List<User> getAllUsers() {
        return userRepository.getAllUsers();
    }
}
