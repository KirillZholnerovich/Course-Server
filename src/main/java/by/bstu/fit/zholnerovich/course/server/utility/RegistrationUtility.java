package by.bstu.fit.zholnerovich.course.server.utility;

import by.bstu.fit.zholnerovich.course.server.soap.RegistreringUser;
import by.bstu.fit.zholnerovich.course.server.entity.User;
import by.bstu.fit.zholnerovich.course.server.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class RegistrationUtility {

    @Autowired
    private UsersRepository usersRepository;

    private static final String ALREADY_REGISTERED = "User with this Username already registered";
    private static final String SUCCESSFUL_REGISTRATION = "User successful registered";
    private static final String UNKNOWN_EXCEPTION = "Unknown exception";

    private List<User> list;

    public RegistrationUtility(){

    }

    public String registrateUser(RegistreringUser userFromRequest){
        list = usersRepository.findAll();
        for (User user : list) {
            if(user.getUsername().equals(userFromRequest.getUsername()))
                return ALREADY_REGISTERED;
        }
        usersRepository.saveAndFlush(new User(userFromRequest.getUsername(), userFromRequest.getPassword()));
        return SUCCESSFUL_REGISTRATION;
    }
}
