package by.bstu.fit.zholnerovich.course.server.utility;

import by.bstu.fit.zholnerovich.course.server.repository.UserRepository;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.soap.UserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationUtility {

    @Autowired
    private UserRepository userRepository;

    private static final String ALREADY_REGISTERED = "User with this Username already registered";
    private static final String SUCCESSFUL_REGISTRATION = "User successful registered";

    private List<User> list;

    public RegistrationUtility(){

    }

    public String registrateUser(UserData userData){
        list = userRepository.findAll();
        for (User user : list) {
            if(user.getLogin().equals(userData.getUsername()))
                return ALREADY_REGISTERED;
        }
        //userRepository.saveAndFlush(new User(userData.getUsername(), userData.getPassword(), userData.getEmail()));
        return SUCCESSFUL_REGISTRATION;
    }
}
